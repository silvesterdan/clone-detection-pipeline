import re
import pathlib

def strip_id_and_save(c2v_in, c2v_out, ids_out):
    """
    Read `c2v_in` that starts with 'ID$methodName ...',
    write clean `.c2v` to `c2v_out` and one ID per line to `ids_out`.
    """
    id_re = re.compile(r"^(\d+)\$")        # adjust if your separator changes

    with open(c2v_in, 'r', encoding='utf-8') as fin, \
         open(c2v_out, 'w', encoding='utf-8') as fout, \
         open(ids_out, 'w', encoding='utf-8') as fid:
        for line in fin:
            # separate the first whitespace‑delimited token
            first, rest = line.split(' ', maxsplit=1)
            m = id_re.match(first)
            if not m:
                raise ValueError(f"Line without numeric ID: {first}")
            fid.write(m.group(1) + '\n')           # write the ID
            fout.write(first.split('$', 1)[1] + ' ' + rest)   # drop "123$"



# # usage
# strip_id_and_save(
#     c2v_in="C:/Users/silve/PycharmProjects/code2vec/data/GPTCloneBench-2ndRound/GPTCloneBench-2ndRound.test.c2v",
#     c2v_out="GPTCloneBench-2ndRound.test.c2v",
#     ids_out="val_ids.txt",
# )


c2v_file_names = ["GPTCloneBench-preprocessed.train.c2v", "GPTCloneBench-preprocessed.val.c2v",
                  "GPTCloneBench-preprocessed.test.c2v"]


SCRIPT_DIR   = pathlib.Path(__file__).resolve().parent
OUTPUT_DIR   = SCRIPT_DIR / "clean_c2v"
OUTPUT_DIR.mkdir(exist_ok=True)

# usage
for c2v_file in c2v_file_names:
    data_type = c2v_file.split(".")[1]


    strip_id_and_save(
        c2v_in = SCRIPT_DIR / "code2vec_mod" / "data" / "GPTCloneBench-preprocessed" / c2v_file,

        # ▼ save both outputs inside clean_c2v/
        c2v_out = OUTPUT_DIR / c2v_file,
        ids_out = OUTPUT_DIR / f"{data_type}_ids_to_embedding_rows.txt",
    )
    print(f"{c2v_file} cleaned and saved to {OUTPUT_DIR}\n")


# for c2v_file in c2v_file_names:
#     strip_id_and_save(
#         c2v_in=f"./code2vec_mod/data/GPTCloneBench-preprocessed/{c2v_file}",
#         c2v_out=f"{c2v_file}",
#         ids_out=f"{c2v_file}_ids_to_embedding_rows.txt"
#     )
    print("\n C2v ID's mapped to the txt files and removed ID's from c2v Files")
    print(f"{c2v_file} file is ready for PyGeometric graph data Conversion! \n")