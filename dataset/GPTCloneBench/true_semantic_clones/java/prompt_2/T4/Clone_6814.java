private void expandAllNodes (JTree tree) {
    int j = tree.getRowCount ();
    int i = 0;
    while (i < j) {
        tree.expandRow (i);
        i += 1;
        j = tree.getRowCount ();
    }
}





private void expandAllNodes(JTree tree) {
    int i = 0;
    do {
        tree.expandRow(i);
        i++;
    } while (i < tree.getRowCount());
}


