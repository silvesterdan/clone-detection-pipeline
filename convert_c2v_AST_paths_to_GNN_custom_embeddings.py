import pathlib, pickle, numpy as np, torch
from torch_geometric.data import Data
import tensorflow as tf
from tqdm import tqdm
import sys

valid = {"train", "val", "test"}
data_type = sys.argv[1] if len(sys.argv) > 1 and sys.argv[1] in valid else "test"
print(f"[info] using data split: {data_type}")

# # Types = train, val, test
# data_type = "test"  # Modify this based on the data type you want to turn into Graph .pt data for the GGNN



# ---------- 0. paths ----------
MODEL_DIR  = pathlib.Path("./code2vec_mod/models/java14_model")
DICT_BIN   = MODEL_DIR / "dictionaries.bin"
CKPT = "./code2vec_mod/models/java14_model/saved_model_iter8.release"
C2V_FILE   = pathlib.Path(f"./clean_c2v/GPTCloneBench-preprocessed.{data_type}.c2v")
GRAPH_DIR  = pathlib.Path(f"graphs-{data_type}"); GRAPH_DIR.mkdir(exist_ok=True)

# ---------- 1. load vocab dictionaries (once!) ----------
with DICT_BIN.open("rb") as f:
    token_to_idx = pickle.load(f)     # object 1  (string ➜ ID)
    pickle.load(f); pickle.load(f)    # objects 2‑3  (skip)
    pickle.load(f); pickle.load(f)    # objects 4‑5  (skip)
    pickle.load(f)                    # object 6  (int, skip)
    path_to_idx  = pickle.load(f)     # object 7  (string ➜ ID)  ← use as‑is
    # object 8 is reverse (ID ➜ string) if you ever want to inspect


print(f"token vocab size: {len(token_to_idx):,}")   # 1 300 852
print(f"path  vocab size: {len(path_to_idx):,}")   #   909 710

# ---------- 2. load embedding matrices (once!) ----------

reader     = tf.train.load_checkpoint(CKPT)
token_emb  = reader.get_tensor("model/WORDS_VOCAB")   # [Vtok,128]
path_emb   = reader.get_tensor("model/PATHS_VOCAB")   # [Vpath,128]

PATH_UNK = 0                       # row 0 is the <UNK> embedding
PATH_MAX = path_emb.shape[0] - 1   # 909710

def context_to_vec(start, path, end):
    s_id = token_to_idx.get(start, 0)      # <UNK> fallback
    p_id = path_to_idx.get(path, 0)      # <UNK> fallback
    e_id = token_to_idx.get(end, 0)

    # # (optional) clamp in case a rare path ID exceeds embedding rows
    # if p_id >= path_emb.shape[0]:
    #     p_id = 0

    s_vec = token_emb[s_id]                # 128‑D
    p_vec = path_emb[p_id]                 # 128‑D
    e_vec = token_emb[e_id]                # 128‑D

    return np.concatenate([s_vec, p_vec, e_vec])   # 384‑D

# ---------- 3. convert ONE raw line to a PyG graph ----------
def method_to_graph(raw_line, max_ctx=200):
    parts     = raw_line.strip().split()
    contexts  = [tuple(p.split(',')[:3]) for p in parts[1:max_ctx+1]]

    # (a) build node feature matrix  [N,384]
    node_feats = torch.tensor(
        np.stack([context_to_vec(*ctx) for ctx in contexts]),
        dtype=torch.float
    )

    # (b) fully‑connected edge list
    N   = node_feats.size(0)
    src, dst = zip(*[(i, j) for i in range(N) for j in range(N) if i != j])
    edge_idx = torch.tensor([src, dst], dtype=torch.long)

    return Data(x=node_feats, edge_index=edge_idx)

# ---------- 4. loop over every method and save graph ----------
with C2V_FILE.open() as fh:
    lines = fh.readlines()

    for mid, line in enumerate(tqdm(lines, desc="Building Graphs")):           # mid = method ID
        graph = method_to_graph(line)
        torch.save(graph, GRAPH_DIR / f"{mid}.pt")

        # if mid % 1000 == 0:
        #     print(f"saved {mid} graphs…")

# ---------- 5. quick sanity check ----------
# 1.  Load one saved graph
g = torch.load(f"./graphs-{data_type}/0.pt", weights_only=False)   # ← tell PyTorch it’s not just weights

# 2.  Quick overview
print(g)                    # e.g.  Data(x=[57, 384], edge_index=[2, 3192])

# 3.  Inspect details
print("⮑ nodes:",      g.num_nodes)
print("⮑ edges:",      g.num_edges)
print("⮑ x shape:",    g.x.shape)          # node‑feature matrix
print("⮑ first node:", g.x[0][:10])        # first 10 dims of node‑0 vector
print("⮑ edge_index sample:\n", g.edge_index[:, :6])   # first 3 edges
