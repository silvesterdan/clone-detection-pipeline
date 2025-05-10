import os
import re
import hashlib
import csv
from pathlib import Path

# ───────────────────────────────────────────────────────────────
# 1. DATASET CONFIGURATION  (edit paths if your layout changes)
# ───────────────────────────────────────────────────────────────
# ── CONFIG ─────────────────────────────────────────────────────
DATASET_ROOT = Path("./dataset/shuffled_split_dataset")
OUTPUT_ROOT  = Path("./dataset/processed-clone-pairs")
DATASETS = [
    ("false_semantic_clones_split", 0),
    ("true_semantic_clones_split",  1),
]
SPLITS = ("train", "valid", "test")


def split_two_methods_brace_based(code):
    def is_escaped(text, i):
        # Check if the " at index `i` is escaped by an odd number of backslashes
        backslash_count = 0
        j = i - 1
        while j >= 0 and text[j] == '\\':
            backslash_count += 1
            j -= 1
        return backslash_count % 2 == 1

    def find_next_method_block(text, start_index):
        i = start_index
        n = len(text)
        brace_start = None
        depth = 0
        in_string = False
        in_char = False
        in_line_comment = False
        in_block_comment = False

        while i < n:
            c = text[i]
            next_c = text[i + 1] if i + 1 < n else ''

            # Toggle out of comments or strings
            if in_line_comment:
                if c == '\n':
                    in_line_comment = False
            elif in_block_comment:
                if c == '*' and next_c == '/':
                    in_block_comment = False
                    i += 1
            elif in_string:
                if c == '"' and not is_escaped(text, i):
                    in_string = False
            elif in_char:
                if c == "'" and not is_escaped(text, i):
                    in_char = False

            # Detect entering strings/comments
            elif c == '/' and next_c == '/':
                in_line_comment = True
                i += 1
            elif c == '/' and next_c == '*':
                in_block_comment = True
                i += 1
            elif c == '"':
                in_string = True
            elif c == "'" and not is_escaped(text, i):
                in_char = True

            # Start method block
            elif c == '{':
                if brace_start is None:
                    brace_start = i

                depth += 1
            elif c == '}' and brace_start is not None:
                depth -= 1
                if depth == 0:
                    # Back‑track to the beginning of the method header
                    method_start = brace_start

                    while method_start > 0:
                        method_start -= 1
                        if text[method_start] == '}':  # end of previous method
                            method_start += 1  # header starts right after
                            break
                    # if while loop finishes without seeing '}', method_start is already 0

                    return text[method_start:i + 1].strip(), i + 1
            i += 1

        print("DEBUG ❌ Failed to extract method at index:", start_index)
        print("Context preview:")
        print(code[start_index:start_index + 200])
        return None, n

    # Extract first method
    method1, next_index = find_next_method_block(code, 0)
    if not method1:
        return None

    while next_index < len(code) and code[next_index].isspace():
        next_index += 1
    # Extract second method from where we left off
    method2, _ = find_next_method_block(code, next_index)
    if not method2:
        print("Could not extract first method.")
        return None

    return method1, method2



# def extract_method_body(code, start_index):
#     """
#     Given the start index of a method signature (which includes '{'),
#     walk forward character-by-character, counting braces until they match up.
#     Return the full text from 'start_index' through the matching closing brace.
#
#     Returns None if we can't find a matching brace.
#     """
#
#     # Find the first '{' from the start_index
#     brace_open_index = code.find('{', start_index)
#     if brace_open_index == -1:
#         return None  # no opening brace found
#
#     # Start counting from the first '{'
#     depth = 0
#     i = brace_open_index
#     n = len(code)
#
#     while i < n:
#         if code[i] == '{':
#             depth += 1
#         elif code[i] == '}':
#             depth -= 1
#             if depth == 0:
#                 # We found the matching '}' that closes this method
#                 return code[start_index: i + 1]  # substring including '}'
#         i += 1
#
#     # If we exit the loop, we never hit depth == 0 again, so no matching '}' was found
#     return None
def normalize_code(code):
    # Remove single-line comments (// comments)
    code = re.sub(r'//.*', '', code)
    # Remove multi-line comments (/* comments */)
    code = re.sub(r'/\*[\s\S]*?\*/', '', code)
    # Collapse multiple whitespaces into a single space and trim
    code = re.sub(r'\s+', ' ', code).strip()
    return code

def hash_code(code):
    normalized = normalize_code(code)
    return hashlib.sha256(normalized.encode('utf-8')).hexdigest()


# ───────────────────────────────────────────────────────────────
# 3.  CORE PROCESSING
# ───────────────────────────────────────────────────────────────
def process_split(source_dir: Path,
                  target_dir: Path,
                  clone_pair_type: int,
                  state: dict,
                  writer):
    """
    Append clone-pair rows with the *given* csv.writer (one per split).
    """
    next_id          = state["next_id"]
    hashed_functions = state["hashed_functions"]

    # deterministic listing, unchanged …
    pair_files = sorted(
        source_dir.iterdir(),
        key=lambda p: int(re.search(r"\d+", p.name)[0])
    )

    for file_path in pair_files:
        code = file_path.read_text(encoding="utf-8", errors="ignore")
        two_methods = split_two_methods_brace_based(code)
        if not two_methods:
            (target_dir / "failed_files.txt").open("a", encoding="utf-8"
            ).write(f"{file_path}\n")
            continue

        func_ids = []
        for func in two_methods:
            h = hash_code(func)
            if h in hashed_functions:
                func_ids.append(hashed_functions[h])
                continue

            func_id = next_id
            next_id += 1
            hashed_functions[h] = func_id
            func_ids.append(func_id)

            (target_dir / f"{func_id}.java").write_text(func, "utf-8")

        writer.writerow([func_ids[0], func_ids[1], clone_pair_type])
        writer.writerow([func_ids[1], func_ids[0], clone_pair_type])

    state["next_id"] = next_id

# ───────────────────────────────────────────────────────────────
# 4.  MAIN LOOP –  (IDs reset for each split)
# ───────────────────────────────────────────────────────────────
def main():
    for split in SPLITS:
        split_dir = OUTPUT_ROOT / split  # ① shared target
        (split_dir / "clone-pairs-csv").mkdir(parents=True, exist_ok=True)

        csv_path = split_dir / "clone-pairs-csv" / "clone_pairs.csv"
        with csv_path.open("w", newline="", encoding="utf-8") as csvfile:
            writer = csv.writer(csvfile)

            # reset split-local state
            state = dict(next_id=0, hashed_functions={})
            print(f"\n=== SPLIT: {split.upper()} (IDs restart) ===")

            for ds_folder, label in DATASETS:
                src = DATASET_ROOT / ds_folder / split
                print(f"  → {src} (label={label})")

                process_split(
                    source_dir=src,
                    target_dir=split_dir,  # ② always the shared dir
                    clone_pair_type=label,
                    state=state,
                    writer=writer  # ③ pass writer, not path
                )

        print(f"   {split} finished. highest ID = {state['next_id'] - 1}")


if __name__ == "__main__":
    main()

