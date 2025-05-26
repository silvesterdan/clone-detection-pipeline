
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
*[Install Windows Subsystem for Linux (WSL)](https://www.youtube.com/watch?v=gTf32sX9ci0&t=85s&ab_channel=TechWithCosta)*.

** Code2Vec pre‑trained model (required for Stage ④  & used again in Stage ⑦) **

The Code2Vec tokenizer expects the original **Java‑14 model**.

1. Click the link below to download the 1.4 GB archive:  
   [Download Code2Vec Java‑14 model](https://s3.amazonaws.com/code2vec/model/java14m_model.tar.gz)

2. Unzip it and place the extracted folder **exactly** here:

```
code2vec_mod/models/java14_model/
├── dict.pkl
├── model.keras
└── … (other model files)
```

The preprocessing scripts are hard‑coded to that path, so no extra flags
are needed.

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

### Console prompts: split & validator

When you run **`python run_preprocess.py`** you will see two interactive checkpoints.

#### 1&nbsp;&nbsp;Split / Shuffle prompt
```text
Do you want to run the dataset splitting stage?
This will override any manual fixes. (y/n):
```
* **`y`** → re‑creates fresh `train / valid / test` folders.  
  Use only the **first** time (or when you intentionally want a new split).
* **`n`** → keeps existing data **untouched** — recommended after you’ve already
  corrected syntax errors or made other manual edits.

#### 2&nbsp;&nbsp;Method‑Validator confirmation
After each split is scanned you’ll get:
```text
INPUT REQUIRED: Please enter 'YES' after you’ve fixed every file listed above
or if no errors were reported (ready to continue):
```
* Open every file listed by the validator, patch syntax issues, **save**.
* When **all** errors are gone, type **`YES`** (uppercase/lowercase).  
  Only then will the pipeline advance to the Code2Vec `preprocess.sh` stage.

> Skipping this step (or typing anything other than `YES`) lets Code2Vec silently
> skip the bad files, which later causes missing graphs and runtime errors during
> training or inference.

### Next steps: training & inference

Once **all preprocessing stages complete successfully** you can move straight to
model work:

| Script | Purpose | Notes |
|--------|---------|-------|
| `CUDA_training_script.py` | Trains the GNN on the freshly-generated `graphs-train/ val/ test/` folders. | Requires a CUDA-enabled GPU and the environment specified in `requirements.txt`. |
| `CUDA_inference_script.py` | Runs inference on test `graphs-*` folder using the **pre-trained weights** bundled in the repo. | Can be executed immediately — training is not mandatory if you only want to reproduce baseline results. |

> **Tip:** if you train a new model, point the inference script to your checkpoint via  
> `--weights path/to/model.pt`.

---

## Quick Start
### Set-up (run these in **Command Prompt / PowerShell**)

```cmd
:: clone the repo
git clone https://github.com/silvesterdan/clone-detection-pipeline.git
cd clone-detection-pipeline        :: enter project root

:: create & activate a fresh venv  (Windows/Linux)
python -m venv .venv

python -m venv .venv && .\.venv\Scripts\activate      # Windows
# source .venv/bin/activate                              # macOS/Linux

### Environment & installation options

By default we assume a **CUDA-capable GPU**.

```bash
# GPU setup
pip install -r requirements.txt          # full CUDA build
```

No CUDA? Training will still run (just slower).  
Create your virtual-env and install the two staged CPU lists instead:

```bash
pip install -r requirements_cpu_stage1.txt
pip install -r requirements_cpu_stage2.txt
```

(Stage 1 = common science deps, Stage 2 = PyTorch-CPU + PyG.)

---

### Output directory layout

After a successful run you should see:

```
dataset/
└─ processed-clone-pairs/
   ├─ train/
   │  ├─ 0.java 1.java …          # individual methods
   │  └─                            (no CSV here)
   ├─ val/
   │  ├─ … .java
   │  └─
   └─ test/
      ├─ … .java
      └─

   train_clone_pairs.csv            # CSVs live *beside* the folders
   val_clone_pairs.csv
   test_clone_pairs.csv

graphs-train/    *.pt               # PyG graphs (repo root)
graphs-val/      *.pt
graphs-test/     *.pt

```

**First run on Windows:** if WSL isn’t installed the script will prompt you —  
follow the video guide *[link‑to‑be‑added]*, then re‑run.

---

## Troubleshooting

| Symptom | Likely Cause | Fix |
|---------|--------------|-----|
| `bash not found` on Windows | WSL missing. | Install WSL (see video). |



PRs welcome 🙂



