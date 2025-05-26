#!/usr/bin/env python3
"""
run_validator_verbose.py – call MethodValidator.jar on train/valid/test
with the --verbose flag so full parser problems are printed.
"""

from pathlib import Path
import subprocess, sys

# ── constants ─────────────────────────────────────────────────────────
ROOT        = Path(__file__).resolve().parent
JAR_PATH    = ROOT / "JavaExecutor" / "target" / "method-validator-1.0-SNAPSHOT-jar-with-dependencies.jar"  # adjust if needed
SPLITS_DIR  = ["train", "valid", "test"]                                # fixed dataset splits
# ──────────────────────────────────────────────────────────────────────

def run_validator() -> bool:
    for split in SPLITS_DIR:
        target_dir = ROOT / "dataset" / "processed-clone-pairs" / split

        print(f"\n🔍  Running MethodValidator (verbose) on **{split}** split")
        print(f"📂  Folder: {target_dir}")

        try:
            subprocess.run(
                ["java", "-jar", str(JAR_PATH), str(target_dir), "--verbose"],
                check=True
            )
            print(f"✅  {split} split validated successfully.\n")
        except subprocess.CalledProcessError as e:
            print(f"❌  Validator failed on {split} (exit code {e.returncode})\n")
            return False           # stop on first failure
    return True                    # all three passed

if __name__ == "__main__":
    ok = run_validator()
    sys.exit(0 if ok else 1)
