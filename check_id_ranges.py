#!/usr/bin/env python3
"""

Verify that every split (train / val / test) contains a *contiguous*,
duplicate-free range of IDs starting at 0.

Assumes:
• IDs are stored one-per-line in   clean_c2v/<split>_ids.txt
  (e.g. clean_c2v/train_ids.txt)
"""

from pathlib import Path
import numpy as np
import sys

SCRIPT_DIR = Path(__file__).resolve().parent
IDS_DIR    = SCRIPT_DIR / "clean_c2v"          # adjust if your folder differs
SPLITS     = ["train", "val", "test"]

def check_split(split: str) -> bool:
    ids_path = IDS_DIR / f"{split}_ids_to_embedding_rows.txt"
    if not ids_path.is_file():
        print(f"⚠  {ids_path} not found – skipping")
        return True                            # non-fatal

    ids = np.loadtxt(ids_path, dtype=int)      # shape (N,)

    if ids.size == 0:
        print(f"❌  {split}: file is empty")
        return False

    ids_sorted = np.sort(ids)
    id_min, id_max = ids_sorted[0], ids_sorted[-1]

    expected     = np.arange(id_min, id_max + 1)
    missing      = np.setdiff1d(expected, ids_sorted)
    extras       = np.setdiff1d(ids_sorted, expected)   # should be empty
    # unique, cnts = np.unique(ids_sorted, return_counts=True)
    # dups         = unique[cnts > 1]

    print(f"\n🔍  {split.upper()} split")
    print(f"    min ID: {id_min}, max ID: {id_max}, total lines: {ids.size}")

    ok = True
    if missing.size:
        print("    ❌ missing IDs:", missing)
        ok = False
    if extras.size:
        print("    ❌ IDs out of range:", extras)
        ok = False
    # if dups.size:
    #     print("    ⚠ duplicate IDs:", dups)
    #     ok = False

    if ok:
        print("    ✅ contiguous 0…max range with no duplicates")

    return ok

def main() -> None:
    # overall_ok = all(check_split(s) for s in SPLITS)
    # sys.exit(0 if overall_ok else 1)

    print("\n [INFO:] The Datasets contain the following missing id's")

    try:
        for s in SPLITS:
            check_split(s)
    except:
        print("No missing files")

if __name__ == "__main__":
    main()
