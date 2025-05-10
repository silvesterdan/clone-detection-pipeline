Dataset Pre-processing Pipeline — Current Status
===============================================

Context
-------
This repository now contains the cleaned up code for my *FYP*  of my Semantic (Type‑4)
Code‑Clone‑Detection project.  The core model & evaluation code is already
final (submitted). I’m currently polishing the **data‑ingestion** layer so
new users can reproduce results with a single command.

Pipeline Overview
-----------------
    raw GPTCloneBench folders
                │
                ▼  ① split_dataset.py
    train / valid / test clone‑pair files
                │
                ▼  ② prepare_clone_dataset.py
    individual <method>.java files  +  clone_pairs.csv

Stage details
-------------
  Stage ① – split_dataset.py
      • Reads raw true_semantic_clones/ & false_semantic_clones/
      • Stratified shuffle → train / valid / test (60 / 20 / 20)

  Stage ② – prepare_clone_dataset.py
      • Extracts 2 top‑level methods from every clone‑pair file
      • De‑duplicates(using method hashing) identical bodies across clone types (per split)
      • Saves one .java per unique method + clone_pairs.csv with labels

Both stages are chained by **run_preprocess.py** (tiny wrapper that just
calls them in order).

Quick start
-----------
    # clone repo & cd into it
    python -m venv .venv && source .venv/bin/activate   # optional
    pip install -r requirements.txt

    # 1‑click preprocessing
    python run_preprocess.py

    # → produces:
    #   processed-clone-pairs/
    #     ├── train/
    #     │   ├── 0.java 1.java …
    #     │   └── clone-pairs-csv/clone_pairs.csv
    #     └── valid/ …   test/ …

No command‑line flags are required yet (paths are hard‑coded), but they will
be exposed in a future commit.

Why fewer .java files than before?
----------------------------------
The new pipeline shares one hash-map per split, so it de-duplicates method files across true and false semantic folders. If the exact same helper method appears in both, it is stored once and referenced by both rows in clone_pairs.csv.

In the old scripts each folder had its own hash-map and ID counter; the map was reset when the next folder started, so identical methods were saved twice (once per folder) and given different IDs. The shared map is why the file count now drops compared to those earlier, folder-specific dumps.



### Roadmap / cleanup checklist  (✅ done · 🟡 in-progress · 🔲 pending)

| Task | Status |
|------|--------|
| Final model & report (FYP submission) | ✅ |
| Consolidate preprocessing into `run_preprocess.py` | ✅ |
| Replace noisy per-file logging with per-split summaries | ✅ |
| Expose `--root` / `--seed` flags via `argparse` | 🟡 |
| Add unit tests for brace-based method extractor | 🟡 |
| Publish training + evaluation scripts in 	  | 🟡 |
| **Pre-process Java files to AST paths with Code2Vec script** | 🔲 |
| **Convert AST-path files to embeddings using Code2Vec pretrained model** | 🔲 |
| **Build fully-connected PyG graphs & save locally** | 🔲 |
| **Training script for PyG graphs (epoch logs + final metric plots)** | 🔲 |
| **Inference script: load trained model, run on test split, print precision/recall/F1** | 🔲 |
| Write full usage guide in wiki | 🔲 |


Last updated: 9-05-2025
