private void printTree (OutputStreamWriter out, boolean isRight, String indent) throws IOException {
    if (right != null) {
        right.printTree (out, true, indent + (isRight ? "        " : " |      "));
    }
    out.write (indent);
    if (isRight) {
        out.write (" /");
    } else {
        out.write (" \\");
    }
    out.write ("----- ");
    printNodeValue (out);
    if (left != null) {
        left.printTree (out, false, indent + (isRight ? " |      " : "        "));
    }
}


private void printTree (OutputStreamWriter out, boolean isLeftTree, String indent) throws IOException {
    if (isLeftTree) {
        if (left != null) {
            left.printTree (out, true, indent + "        ");
        }
    }
    else {
        if (right != null) {
            right.printTree (out, false, indent + " |      ");
        }
    }
    out.write (indent);
    if (isLeftTree) {
        out.write (" \\");
    } else {
        out.write (" /");
    }
    out.write ("----- ");
    printNodeValue (out);
    if (isLeftTree) {
        if (right != null) {
            right.printTree (out, false, indent + " |      ");
        }
    }
    else {
        if (left != null) {
            left.printTree (out, true, indent + "        ");
        }
    }
}


