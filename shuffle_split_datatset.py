#!/usr/bin/env python3
import os
import sys
import shutil
import random
import math

# === CONFIGURATION ===
# Path to the original dataset directory (should be placed in the project)
original_dataset_false_semantic = "./dataset/GPTCloneBench/false_semantic_clones"  # change if needed
original_dataset_true_semantic_p1 = "./dataset/GPTCloneBench/true_semantic_clones/java/prompt_1/T4"  # change if needed
original_dataset_true_semantic_p2 = "./dataset/GPTCloneBench/true_semantic_clones/java/prompt_2/T4"  # change if needed

# Output directory where train/valid/test folders will be created
output_base_dir_false_sem = "./dataset/shuffled_split_dataset/false_semantic_clones_split"
output_base_dir_true_sem_p1 = "./dataset/shuffled_split_dataset/true_semantic_clones_split"
output_base_dir_true_sem_p2 = "./dataset/shuffled_split_dataset/true_semantic_clones_split"

# Define percentage splits (they should add to 1.0)
train_percent = 0.6
valid_percent = 0.2
test_percent = 0.2

# Set to True if you want to copy; set to False to move files (be careful with moving!)
copy_files = True


# ======================

def create_folder_if_not_exists(path):
    if not os.path.exists(path):
        os.makedirs(path)
        print(f"Created folder: {path}")


def split_dataset(original_dataset_dir, output_base_dir):
    # List all files in original_dataset_dir (only files, not subdirs)
    all_files = [f for f in os.listdir(original_dataset_dir) if os.path.isfile(os.path.join(original_dataset_dir, f))]

    if not all_files:
        print("No files found in the original dataset directory.")
        sys.exit(1)

    # Shuffle in memory
    random.seed(42)
    random.shuffle(all_files)

    total_files = len(all_files)
    train_count = math.floor(total_files * train_percent)
    valid_count = math.floor(total_files * valid_percent)
    # Everything else goes to test
    test_count = total_files - train_count - valid_count

    print(f"Total files: {total_files}")
    print(f"Train: {train_count}, Valid: {valid_count}, Test: {test_count}")

    # Create output directories
    train_dir = os.path.join(output_base_dir, "train")
    valid_dir = os.path.join(output_base_dir, "valid")
    test_dir = os.path.join(output_base_dir, "test")
    for folder in [output_base_dir, train_dir, valid_dir, test_dir]:
        create_folder_if_not_exists(folder)

    # Splitting files list:
    train_files = all_files[:train_count]
    valid_files = all_files[train_count:train_count + valid_count]
    test_files = all_files[train_count + valid_count:]

    # A function to copy or move file from source to destination folder
    def transfer_files(file_list, target_dir):
        for f in file_list:
            src = os.path.join(original_dataset_dir, f)
            dst = os.path.join(target_dir, f)
            if copy_files:
                shutil.copy2(src, dst)  # copy metadata as well
            else:
                shutil.move(src, dst)
            # print(f"{'Copied' if copy_files else 'Moved'}: {f} -> {target_dir}")

    # Transfer files to respective folders
    print("\nTransferring Training files...")
    transfer_files(train_files, train_dir)

    print("\nTransferring Validation files...")
    transfer_files(valid_files, valid_dir)

    print("\nTransferring Test files...")
    transfer_files(test_files, test_dir)

    print("\nDataset split completed successfully.")

    print("\n","-" * 50, "\n" )


if __name__ == "__main__":
    split_dataset(original_dataset_false_semantic, output_base_dir_false_sem)
    split_dataset(original_dataset_true_semantic_p1, output_base_dir_true_sem_p1)
    split_dataset(original_dataset_true_semantic_p2, output_base_dir_true_sem_p2)