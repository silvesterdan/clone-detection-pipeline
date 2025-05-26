
# Dataset Pre‑processing & Graph‑Building Pipeline

## Context
This repository hosts the **entire data‑ingestion tool‑chain** for my FYP  
*“Semantic (Type‑4) Code‑Clone Detection via GNNs and Code2Vec Embeddings”*.

* **Model code & evaluation** are already frozen.  
* This pipeline lets **anyone** recreate the exact training graphs with **one command**.

> **TL;DR** `python run_preprocess.py` takes raw GPTCloneBench data and  
> outputs ready‑to‑train `graphs‑{train|val|test}/` folders.

---

## Pipeline Overview

```text
raw GPTCloneBench
        │
        ▼ ① shuffle_split_dataset.py
train / valid / test clone‑pair folders
        │
        ▼ ② split_clone_pair_methods_and_log_csv.py
one <method>.java per file  +  clone_pairs.csv
        │
        ▼ ③ Java MethodValidator (jar)
validated processed‑clone‑pairs/{train|val|test}
        │
        ▼ ④ code2vec_mod/preprocess.sh   (runs **inside WSL**)
AST‑path .c2v files  +  id‑mapping
        │
        ▼ ⑤ code2vec_strip_id_from_c2v_and_save_to_txtFile_ID.py
*.txt lists of AST‑path IDs  per split
        │
        ▼ ⑥ check_id_ranges.py
verifies contiguous 0..N IDs (no gaps / dups)
        │
        ▼ ⑦ convert_c2v_AST_paths_to_GNN_custom_embeddings.py {train|val|test}
PyG‑ready graphs‑{split}/  (binary `.pt`)
```

**WSL requirement**  
Stage ④ relies on original *code2vec* bash scripts.  
Windows users must enable **Windows Subsystem for Linux (WSL)** – see video tutorial  
*[link‑to‑be‑added]*.

---

## Stage‑by‑Stage Details

| # | Script / File | Responsibility |
|---|---------------|----------------|
| **①** | `shuffle_split_dataset.py` | Stratified shuffle of *true* and *false* semantic clone folders → `train / valid / test` (60 / 20 / 20). |
| **②** | `split_clone_pair_methods_and_log_csv.py` | Extracts the **two top‑level methods** from each clone‑pair file.<br>Generates one `.java` per **unique** method (hash‑dedup) and logs pairs & labels to `clone_pairs.csv`. |
| **③** | *MethodValidator JAR* | Parses every `.java` to ensure it compiles as a valid method.<br>**Manual fixes applied:** syntax errors were corrected for each split (**train 10**, **valid 6**, **test 4**).<br>If syntax errors remain, `code2vec/preprocess.sh` will skip those files causing missing graphs against `clone_pairs.csv`. |
| **④** | `code2vec_mod/preprocess.sh` & `bootstrap_env.sh` | Original *code2vec* tokenizer — emits AST‑path `.c2v` files. Automatically runs in WSL on Windows, Bash on \*nix. |
| **⑤** | `code2vec_strip_id_from_c2v_and_save_to_txtFile_ID.py` | Extracts numeric IDs from `.c2v` headers → compact `.txt` lists per split. |
| **⑥** | `check_id_ranges.py` | Verifies each split’s ID list is **contiguous starting at 0** (no gaps / duplicates). |
| **⑦** | `convert_c2v_AST_paths_to_GNN_custom_embeddings.py` | For each split:<br>1. Loads `.c2v` AST paths<br>2. Encodes via a Code2Vec model<br>3. Saves PyTorch‑Geometric graphs → `graphs‑{train|val|test}/`. |

`run_preprocess.py` chains all stages, detects Windows vs Linux/macOS, prompts
before re‑splitting, loops the validator until you type `YES`, and aborts on first
non‑zero exit code.

---

## Quick Start

```bash
# clone repo & enter
python -m venv .venv && .\.venv\Scripts\activate      # Windows
# source .venv/bin/activate                              # macOS/Linux

pip install -r requirements.txt

# ---- ONE COMMAND ----
python run_preprocess.py
# ----------------------

# Outputs:
# dataset/
#   ├─ processed-clone-pairs/{train,val,test}/
#   ├─ graphs-train/   *.pt
#   ├─ graphs-val/     *.pt
#   └─ graphs-test/    *.pt
```

**First run on Windows:** if WSL isn’t installed the script will prompt you —  
follow the video guide *[link‑to‑be‑added]*, then re‑run.

---

## Troubleshooting

| Symptom | Likely Cause | Fix |
|---------|--------------|-----|
| `bash not found` on Windows | WSL missing. | Install WSL (see video). |



PRs welcome 🙂



