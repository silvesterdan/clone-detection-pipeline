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

import subprocess
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parent  # directory that holds this script

STAGES = [
    "shuffle_split_datatset.py",          # stage 1: create train/valid/test splits
    "split_clone_pair_methods_and_log_csv.py", # stage 2: deduplicate + CSV generation
]


def main() -> None:
    """Run each pipeline stage sequentially; abort on first error."""
    for script in STAGES:
        cmd = [sys.executable, str(ROOT / script)]
        print("\n→", " ".join(cmd))
        subprocess.run(cmd, check=True)

    print("\n✅  All preprocessing stages completed successfully.")


if __name__ == "__main__":
    main()
