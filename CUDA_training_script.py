# unified_clone_pipeline_cuda.py
# ──────────────────────────────
from ml_models.models import MethodEncoder, build_clf_head
import pathlib, csv, torch, torch.nn as nn
from torch.utils.data import Dataset, DataLoader
from torch.optim.lr_scheduler import ReduceLROnPlateau
from torch_geometric.nn import GCNConv, global_mean_pool
from torch_geometric.data import Batch
from tqdm import tqdm
from sklearn.metrics import f1_score

from sklearn.metrics import classification_report, confusion_matrix, \
    average_precision_score, precision_recall_curve

# ── 0. pick the device ──────────────────────────────────────────
device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
# print("Running on", device)                      # expect “cuda”

# ── 1. paths & file-to-methods look-ups  (unchanged) ───────────
MODEL_DIR       = pathlib.Path("./models/java14_model")
TRAIN_ID_FILE   = pathlib.Path("./clean_c2v/train_ids_to_embedding_rows.txt")
VAL_ID_FILE     = pathlib.Path("./clean_c2v/val_ids_to_embedding_rows.txt")
TRAIN_GRAPH_DIR = pathlib.Path("graphs-train")
VAL_GRAPH_DIR   = pathlib.Path("graphs-val")

def build_map(id_file: pathlib.Path):
    f2m = {}
    with id_file.open() as fh:
        for mid, line in enumerate(fh):
            f2m.setdefault(int(line.strip()), []).append(mid)
    return f2m

train_file2methods = build_map(TRAIN_ID_FILE)
val_file2methods   = build_map(VAL_ID_FILE)

# ── 2. encoder that will run on GPU ─────────────────────────────
# class MethodEncoder(nn.Module):
#     def __init__(self, in_dim=384, hidden=256, steps=3):
#         super().__init__()
#         self.convs = nn.ModuleList(
#             [GCNConv(in_dim if i == 0 else hidden, hidden) for i in range(steps)]
#         )
#     def forward(self, batch_graph):
#         x, edge_index, batch = batch_graph.x, batch_graph.edge_index, batch_graph.batch
#         for conv in self.convs:
#             x = torch.relu(conv(x, edge_index))
#         return global_mean_pool(x, batch)

encoder = MethodEncoder().to(device)          # ← GPU

# ── 3. helper: file-id → 256-D vector  (now moves Batch to GPU) ─
def embed_file(file_id, f2m, graph_dir, encoder_model):
    mids   = f2m[file_id]
    graphs = [torch.load(graph_dir/f"{mid}.pt", weights_only=False) for mid in mids]
    batch  = Batch.from_data_list(graphs).to(device)      # ← GPU
    m_vecs = encoder_model(batch)                               # [n_methods,256] on GPU
    return m_vecs.mean(0)                                 # [256] on GPU


# ── keep this at module level ──────────────────────────
class FilePairDataset(Dataset):
        def __init__(self, plist): self.pairs = plist
        def __len__(self): return len(self.pairs)
        def __getitem__(self, idx):
            a,b,lbl = self.pairs[idx]
            return a, b, torch.tensor(lbl, dtype=torch.float)


def main():
    # ── 4. load pair CSVs and DataLoaders (unchanged) ───────────────
    def load_pairs(csv_path):
        pairs = []
        with csv_path.open() as f:
            for a, b, lbl in csv.reader(f):
                pairs.append((int(a), int(b), float(lbl)))
        return pairs

    train_pairs = load_pairs(pathlib.Path("./dataset/processed-clone-pairs/train_clone_pairs.csv"))
    val_pairs   = load_pairs(pathlib.Path("./dataset/processed-clone-pairs/valid_clone_pairs.csv"))


    train_loader = DataLoader(FilePairDataset(train_pairs), batch_size=32,
                              shuffle=True,  num_workers=4, pin_memory=True)
    val_loader   = DataLoader(FilePairDataset(val_pairs),   batch_size=64,
                              shuffle=False, num_workers=4, pin_memory=True)

    # ── 5. classifier head & optimiser on GPU ───────────────────────
    # clf_head = nn.Sequential(
    #     nn.Linear(256*3, 128),
    #     nn.ReLU(),
    #     nn.Linear(128, 1),
    #     nn.Sigmoid()
    # ).to(device)

    clf_head = build_clf_head().to(device)

    optimizer = torch.optim.Adam(
        list(encoder.parameters()) + list(clf_head.parameters()),
        lr=5e-4,  # base learning-rate
        weight_decay=1e-4  # small L2 regularisation (helps GGNN)
    )

    scheduler = ReduceLROnPlateau(
        optimizer,  # object whose LR we will change
        mode='min',  # we are *minimising* val_loss
        factor=0.5,  # when triggered, LR ← LR × 0.5
        patience=2,  # wait 2 “no-improve” epochs
        verbose=True  # print a message when LR drops
    )
    # loss_fn   = nn.BCELoss()

    # -------- weighted BCEWithLogits ---------
    pos_ratio = sum(lbl for *_, lbl in train_pairs) / len(train_pairs)
    pos_weight = torch.tensor([(1 - pos_ratio) / pos_ratio], device=device)
    loss_fn = nn.BCEWithLogitsLoss()

    # ── 6. training + validation loops ──────────────────────────────


    max_epochs, patience = 20, 6
    best_val_f1, epochs_no_improve = 0., 0
    f1_hist, ap_hist, loss_hist = [], [], []
    best_rec = 0.0
    best_prec = 0.0
    best_ap = 0.0
    best_rec_curve, best_prec_curve = None, None  # ← NEW

    for epoch in range(max_epochs):
        # ---- TRAIN ----
        encoder.train(); clf_head.train()
        running_loss = 0.0
        for A_ids, B_ids, labels in tqdm(train_loader, desc=f"train {epoch}", leave=True):
            labels = labels.to(device, non_blocking=True)
            vecA = torch.stack([embed_file(int(fid), train_file2methods, TRAIN_GRAPH_DIR, encoder)
                                for fid in A_ids]).to(device)
            vecB = torch.stack([embed_file(int(fid), train_file2methods, TRAIN_GRAPH_DIR, encoder)
                                for fid in B_ids]).to(device)

            feats = torch.cat([vecA, vecB, torch.abs(vecA-vecB)], 1)

            # -------- training step ------------------
            # preds = clf_head(feats).squeeze(1)

            logits = clf_head(feats).squeeze(1)  # raw scores

            # loss  = loss_fn(preds, labels)

            loss = loss_fn(logits, labels)

            # optimizer.zero_grad(); loss.backward(); optimizer.step()

            optimizer.zero_grad()
            loss.backward()
            # torch.nn.utils.clip_grad_norm_(encoder.parameters(), 1.0)
            torch.nn.utils.clip_grad_norm_(
                 list(encoder.parameters()) + list(clf_head.parameters()), 1.0
            )
            optimizer.step()

            running_loss += loss.item()*labels.size(0)
        train_loss = running_loss / len(train_pairs)

        # ---- VALIDATE ----
        encoder.eval(); clf_head.eval()


        all_p, all_l = [], []
        with torch.no_grad():
            for A_ids,B_ids,labels in tqdm(val_loader, desc="val", leave=True):
                labels = labels.to(device, non_blocking=True)
                vA = torch.stack([embed_file(int(fid), val_file2methods, VAL_GRAPH_DIR, encoder)
                                  for fid in A_ids]).to(device)
                vB = torch.stack([embed_file(int(fid), val_file2methods, VAL_GRAPH_DIR, encoder)
                                  for fid in B_ids]).to(device)
                logits = clf_head(torch.cat([vA, vB, torch.abs(vA-vB)],1)).squeeze(1)
                all_p.append(logits)
                all_l.append(labels)



        import matplotlib.pyplot as plt

        logits  = torch.cat(all_p)
        labels = torch.cat(all_l)

        val_loss = loss_fn(logits, labels).item()
        # probs = torch.sigmoid(logits)

        # val_f1   = f1_score(labels.cpu(), (probs>0.5).cpu())

        # ────────────────────  metrics & diagnostics  ────────────────────

        probs = torch.sigmoid(logits).cpu().numpy()  # continuous scores  ∈ [0,1]
        lbls = labels.cpu().numpy()  # ground-truth 0 / 1

        # threshold that maximises F1
        prec, rec, thr = precision_recall_curve(lbls, probs)
        f1s = 2 * prec * rec / (prec + rec + 1e-8)
        best_idx = f1s.argmax()

        best_thr = thr[best_idx]  # ← use for y_pred, checkpoint
        val_f1 = f1s[best_idx]
        val_prec = prec[best_idx]
        val_rec = rec[best_idx]
        val_ap = average_precision_score(lbls, probs)

        # log to tqdm
        tqdm.write(
            f"ep:{epoch:02d}  train_loss:{train_loss:.4f}  "
            f"val_loss:{val_loss:.4f}  "
            f"P:{val_prec:.3f}  R:{val_rec:.3f}  "
            f"F1:{val_f1:.3f}  AP:{val_ap:.3f}"
        )

        # OPTIONAL: deeper diagnostics (prints once per epoch)
        y_pred = (probs > best_thr).astype(int)

        print("\n" + classification_report(lbls, y_pred, digits=3))
        print("Confusion matrix:\n", confusion_matrix(lbls, y_pred))
        print(f"Average precision (area under PR curve): {val_ap:.3f}")

        #  learning-curve logs
        loss_hist.append(val_loss)
        f1_hist.append(val_f1)
        ap_hist.append(val_ap)


        # ---- EARLY STOP ----
        if val_f1 > best_val_f1 + 1e-4:
            best_val_f1 = val_f1; epochs_no_improve = 0
            best_rec, best_prec, best_ap = val_rec, val_prec, val_ap
            best_rec_curve = rec  # ← keep the arrays!
            best_prec_curve = prec
            best_ap = val_ap


            # Save the Best model for the GGNN Encoder and Head for the Classifier head.
            pathlib.Path("model").mkdir(exist_ok=True)  # before torch.save

            torch.save({
                'epoch': epoch,  # NEW
                'enc': encoder.state_dict(),
                'head': clf_head.state_dict(),
                'opt': optimizer.state_dict(),  # NEW
                'sch': scheduler.state_dict(),  # NEW
                'thr': best_thr,
                'val_f1': best_val_f1,  # NEW
                # 'rec_curve':  best_rec_curve,      # optional
                # 'prec_curve': best_prec_curve      # optional
            }, "ml_models/best-GGNN-E.pt")
        else:
            epochs_no_improve += 1
            if epochs_no_improve >= patience:
                # printing without affecting the tqdm progress bar display
                tqdm.write("Early stop: no validation improvement."); break

        # ----------------------------------------------------------------------
        # SCHEDULER STEP  , once per epoch after validation (if you added ReduceLROnPlateau)
        # ----------------------------------------------------------------------
        scheduler.step(val_loss)
    # ================= END OF TRAINING LOOP =========================

    # ── 1) plot the learning curves (A) ------------------------------
    import matplotlib.pyplot as plt
    epochs = list(range(1, len(f1_hist) + 1))

    plt.figure(figsize=(6, 4))
    plt.plot(epochs, f1_hist, label='F1', marker='o')
    plt.plot(epochs, ap_hist, label='AP', marker='s')
    plt.plot(epochs, loss_hist, label='val loss', marker='x')
    plt.xlabel("epoch"),
    plt.grid(True),
    plt.legend()
    plt.title("Validation metrics over epochs")
    plt.tight_layout()
    plt.savefig("GGNN_val_f1-ap-loss.png", dpi=300, bbox_inches="tight")
    plt.show()


    # ── 2) plot the best PR-curve (B) --------------------------------
    plt.figure()
    plt.plot(best_rec_curve, best_prec_curve)
    plt.xlabel("Recall"),
    plt.ylabel("Precision")
    plt.title(f"Best PR curve  (F1={best_val_f1:.3f},  AP={best_ap:.3f})")
    plt.tight_layout()
    plt.savefig("GGNN_val_rec-prec-ap.png", dpi=300, bbox_inches="tight")
    plt.show()



if __name__ == "__main__":
    device = torch.device('cuda' if torch.cuda.is_available() else 'cpu')
    print("Running on", device)
    main()