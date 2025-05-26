# models.py  (shared library)
import torch, torch.nn as nn
from torch_geometric.nn import GatedGraphConv, global_mean_pool
from torch_geometric.nn import GCNConv

# GGNN Encoder Model: E
class MethodEncoder(nn.Module):
    def __init__(self, in_dim=384, hidden=256, steps=5, p_drop=0.1):
        super().__init__()
        self.lin   = nn.Linear(in_dim, hidden)
        self.drop  = nn.Dropout(p_drop)
        self.norm  = nn.LayerNorm(hidden)
        self.ggnn  = GatedGraphConv(hidden, steps)

    def forward(self, g):
        x = torch.relu(self.lin(g.x))
        x = self.drop(self.norm(x))
        x = self.ggnn(x, g.edge_index)
        x = self.norm(x)
        return global_mean_pool(x, g.batch)


#   Classification head
def build_clf_head(hidden: int = 256, mid: int = 128) -> nn.Sequential:
    """
    Returns a 2-layer MLP that scores a pair of method-embeddings.

    Input features = [vecA, vecB, |vecA-vecB|]  →  3 × hidden
    Output         = single logit (no sigmoid; use BCEWithLogitsLoss)
    """
    return nn.Sequential(
        nn.Linear(hidden * 3, mid),
        nn.ReLU(),
        nn.Linear(mid, 1)          # 1 logit
    )

# GCN Method Encoder Model A
# class MethodEncoder(nn.Module):
#     """GGNN‑style encoder: method‑graph → 256‑D vector"""
#     def __init__(self, in_dim=384, hidden=256, steps=3):
#         super().__init__()
#         self.convs = nn.ModuleList([
#             GCNConv(in_dim if i == 0 else hidden, hidden)
#             for i in range(steps)
#         ])
#     def forward(self, batch_graph):
#         x, edge_index, batch = batch_graph.x, batch_graph.edge_index, batch_graph.batch
#         for conv in self.convs:
#             x = torch.relu(conv(x, edge_index))
#         return global_mean_pool(x, batch)   # one vector per method
