"""
clone_inference.py  ·  improved
Run a trained clone-detection checkpoint on a test-pair CSV,
produce metrics, precision-recall plot, and (optionally) raw
prediction CSV.

Changes vs. the original
────────────────────────
▪ Uses *exactly* the same loss as training (BCEWithLogitsLoss).
▪ Applies the best-validation threshold saved in the checkpoint
  instead of hard-coding 0.5.
▪ Adds a tiny in-memory cache so each source file is embedded once,
  even if it appears in many pairs.
▪ Argparse flags:  --ckpt, --batch, --out_csv, --amp.
▪ PR-curve plot marks the deployment threshold.
"""

import argparse, csv, pathlib, sys

import numpy as np
import torch
import torch.nn as nn
import matplotlib.pyplot as plt
from sklearn.metrics import (
    accuracy_score,
    precision_score,
    recall_score,
    classification_report,
    confusion_matrix,
    precision_recall_curve,
    average_precision_score,
    f1_score,
)
from tqdm import tqdm

# ── repo-local imports (leave as-is) ────────────────────────────
from ml_models.models import MethodEncoder, build_clf_head
from CUDA_training_script import (
    build_map,
    embed_file,
    FilePairDataset,
    DataLoader,
)

# ────────────────────────────────────────────────────────────────
# 0.  CLI & environment
# ────────────────────────────────────────────────────────────────
parser = argparse.ArgumentParser()
parser.add_argument("--ckpt", default="ml_models/best-GGNN-E.pt",
                    help="checkpoint with keys enc, head, thr")
parser.add_argument("--batch", type=int, default=64,
                    help="mini-batch size for pair loader")
parser.add_argument("--out_csv", default=None,
                    help="if set, dump y_true,y_prob to this CSV")
parser.add_argument("--amp", action="store_true",
                    help="enable automatic mixed precision")
args = parser.parse_args()

device = torch.device("cuda" if torch.cuda.is_available() else "cpu")



def main():
    print(f"Running on {device}")
    # ────────────────────────────────────────────────────────────────
    # 1.  Paths & look-ups
    # ────────────────────────────────────────────────────────────────
    TEST_ID_FILE   = pathlib.Path("./clean_c2v/test_ids_to_embedding_rows.txt")
    TEST_GRAPH_DIR = pathlib.Path("graphs-test")
    CSV_PAIRS      = pathlib.Path("./dataset/processed-clone-pairs/test_clone_pairs.csv")

    test_file2methods = build_map(TEST_ID_FILE)

    # ────────────────────────────────────────────────────────────────
    # 2.  Rebuild model & load weights
    # ────────────────────────────────────────────────────────────────
    encoder  = MethodEncoder().to(device)
    clf_head = build_clf_head().to(device)

    ckpt = torch.load(args.ckpt, map_location=device)
    encoder.load_state_dict(ckpt["enc"])
    clf_head.load_state_dict(ckpt["head"])
    thr = float(ckpt.get("thr", 0.5))          # fall back to 0.5 if absent
    encoder.eval(); clf_head.eval()

    print(f"✓ Weights & threshold ({thr:.3f}) loaded")

    # ────────────────────────────────────────────────────────────────
    # 3.  Data
    # ────────────────────────────────────────────────────────────────
    def load_pairs(csv_path):
        pairs = []
        with csv_path.open() as f:
            for a, b, lbl in csv.reader(f):
                pairs.append((int(a), int(b), float(lbl)))
        return pairs

    test_pairs  = load_pairs(CSV_PAIRS)
    test_loader = DataLoader(
        FilePairDataset(test_pairs),
        batch_size=args.batch,
        shuffle=False, num_workers=4, pin_memory=(device.type == "cuda")
    )



    # ────────────────────────────────────────────────────────────────
    # 4.  Inference loop
    # ────────────────────────────────────────────────────────────────
    loss_fn = nn.BCEWithLogitsLoss()           # parity with training
    all_logits, all_labels = [], []

    # tiny embedding cache to avoid re-encoding duplicates
    _embed_cache = {}
    def cached_embed(fid: int):
        if fid not in _embed_cache:
            _embed_cache[fid] = embed_file(
                fid, test_file2methods, TEST_GRAPH_DIR, encoder
            )
        return _embed_cache[fid]

    amp_ctx = torch.cuda.amp.autocast if args.amp else torch.no_grad

    with torch.no_grad():
        for A_ids, B_ids, labels in tqdm(test_loader, desc="test"):
            labels = labels.to(device, non_blocking=True)

            with amp_ctx():
                vA = torch.stack([cached_embed(int(fid)) for fid in A_ids]).to(device)
                vB = torch.stack([cached_embed(int(fid)) for fid in B_ids]).to(device)
                feats  = torch.cat([vA, vB, torch.abs(vA - vB)], dim=1)
                logits = clf_head(feats).squeeze(1)   # [B]

            all_logits.append(logits)
            all_labels.append(labels)

    logits = torch.cat(all_logits)
    labels = torch.cat(all_labels)

    test_loss = loss_fn(logits, labels).item()
    probs = torch.sigmoid(logits).cpu().numpy()
    y_true = labels.cpu().numpy()
    y_pred = (probs > thr).astype(int)



    # 1. scalar metrics at the chosen threshold
    acc = accuracy_score(y_true, y_pred)
    p_at_thr = precision_score(y_true, y_pred)
    r_at_thr = recall_score(y_true, y_pred)
    f1_at_thr = f1_score(y_true, y_pred)

    # 2. full PR curve (arrays).  Use distinct names.
    pr_prec, pr_rec, thr_curve = precision_recall_curve(y_true, probs)
    ap = average_precision_score(y_true, probs)

    # 3. headline one-liner
    print(f"TEST | loss {test_loss:.4f} | acc {acc:.3f} | "
          f"P {p_at_thr:.3f} | R {r_at_thr:.3f} | "
          f"F1 {f1_at_thr:.3f} | AP {ap:.3f} | thr {thr:.2f}")



    # 4. plot
    plt.figure(figsize=(4, 4))
    plt.plot(pr_rec, pr_prec, label=f"PR (AP={ap:.3f})")

    if thr_curve.size:
        idx_thr = (np.abs(thr_curve - thr)).argmin()
        plt.scatter(pr_rec[idx_thr], pr_prec[idx_thr],
                    s=40, marker='o', label=f"thr={thr:.2f}")

    plt.xlabel("Recall");
    plt.ylabel("Precision")
    plt.title(f"TEST PR  (F1={f1_at_thr:.3f})")
    plt.grid(True);
    plt.legend();
    plt.tight_layout()
    plt.show()

    # ── 6.  Optional: dump raw preds ────────────────────────────────
    if args.out_csv:
        import pandas as pd
        pd.DataFrame({"y_true": y_true, "y_prob": probs}).to_csv(args.out_csv,
                                                                 index=False)
        print(f"↳ raw predictions written to {args.out_csv}")

# ── Windows needs this guard so worker subprocesses don’t rerun code ──
if __name__ == "__main__":
    import torch.multiprocessing as mp
    mp.freeze_support()   # no-op on Linux/Mac; required on Windows
    main()
