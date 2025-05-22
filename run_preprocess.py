#!/usr/bin/env python3
"""
run_preprocess.py  –  extremely lightweight wrapper that chains the two
pipeline stages with **no** argument‑parsing magic and **no** imports.

Usage
-----
    # from the repo root (all paths are relative)
    python run_preprocess.py

How it works
------------
1. Invokes   `split_dataset.py`   in a fresh Python process.
2. Invokes   `prepare_clone_dataset.py`   right after the first stage
   finishes.
3. Propagates any non‑zero exit code so your CI or shell can detect
   failure.

Because every call is done through `subprocess.run([...])`, this file is
platform‑agnostic and utterly simple to read.
"""

from __future__ import annotations

import subprocess, platform
import sys
from pathlib import Path

ROOT         = Path(__file__).resolve().parent  # directory that holds this script
C2V_ROOT     = ROOT / "code2vec_mod"
SH_FILE      = C2V_ROOT / "preprocess.sh"
SH_VENV_FILE = C2V_ROOT / "bootstrap_env.sh"

STAGES = [
    "shuffle_split_datatset.py",          # stage 1: create train/valid/test splits
    "split_clone_pair_methods_and_log_csv.py", # stage 2: deduplicate + CSV generation
]
SPLITS_DIR = ["train", "valid", "test"]



jar_path     = ROOT / "JavaExecutor" / "target" / "method-validator-1.0-SNAPSHOT-jar-with-dependencies.jar"
# target_dir   = ROOT / "dataset" / "processed-clone-pairs"   # up one, then down


def run_validator() -> bool:
    for split in SPLITS_DIR:
        target_dir = ROOT / "dataset" / "processed-clone-pairs" / split

        print(f"\n                 🔍 Running MethodValidator on **{split.capitalize()}** split..\n")
        print(f"📂 Folder: {target_dir}")

        try:
            subprocess.run(
                ["java", "-jar", str(jar_path), str(target_dir)],
                check=True
            )
            print(f"{split.capitalize()} split validated successfully.\n")
        except subprocess.CalledProcessError as e:
            print(f"\n Validator failed on {split} split with exit code {e.returncode}\n")
            break  # or raise if you want to halt the pipeline


# ── helper: convert Windows path → WSL path if needed ────────────
def to_wsl_path(p: Path) -> str:
    if platform.system() != "Windows":
        return str(p)
    p = p.resolve()
    drive = p.drive.rstrip(":").lower()           # 'C' → 'c'
    rest  = p.as_posix().split(":", 1)[-1]        # drop 'C:'
    return f"/mnt/{drive}{rest}"

if platform.system() == "Windows":
    STAGES.append((["wsl", "bash", to_wsl_path(SH_VENV_FILE)], to_wsl_path(C2V_ROOT)))
    STAGES.append((["wsl", "bash", to_wsl_path(SH_FILE)], to_wsl_path(C2V_ROOT)))

else:                  # Linux / macOS host
    STAGES.append((["bash", str(SH_FILE)],          str(C2V_ROOT)))


def main() -> None:
    """Run each pipeline stage sequentially; abort on first error."""
    for script in STAGES[:2]:
        cmd = [sys.executable, str(ROOT / script)]
        print("\n→", " ".join(cmd))
        subprocess.run(cmd, check=True)




    # flag = True
    while True:
        run_validator()
        user_input = input("INPUT REQUIRED: Pleas enter 'Yes' if fixed displayed errors manually "
                           "\n or there are no files with issues  and ready to move forward: ").upper()
        if user_input == "YES":
            # flag = False
            break
        # else:
        #     user_input = input("You entered an invalid command please enter 'Yes' if ready to move forward!")

    print("\n INFO: All validator stages completed.")


    for cmd, workdir in STAGES[2:]:
        cmd = list(map(str, cmd))               # Path → str
        print("\n→", " ".join(cmd))
        subprocess.run(cmd, check=True, cwd=C2V_ROOT)


    print("\n INFO:  All preprocessing stages completed successfully.")


if __name__ == "__main__":
    main()
