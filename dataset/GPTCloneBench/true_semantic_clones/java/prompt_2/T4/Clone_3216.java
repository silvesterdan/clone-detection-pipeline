public int solution (int X, int [] A) {
    Set < Integer > leaves = new HashSet < > ();
    for (int i = 0;
    i < A.length; i ++) {
        leaves.add (A [i]);
        if (leaves.contains (X) && leaves.size () == X) return i;
    }
    return - 1;
}




public int solution(int X, int[] A) {
    java.util.LinkedHashSet<Integer> leaves = new java.util.LinkedHashSet<>();
    int i = 0;
    while(i < A.length) {
        leaves.add(A[i]);
        if (leaves.contains(X) && leaves.size() == X) return i;
        i++;
    }
    return -1;
}


