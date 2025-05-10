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
    Set<Integer> leaves = new HashSet<>();
    int i = 0;
    do {
        leaves.add(A[i]);
        if (leaves.size() == X && leaves.contains(X))
           return i;
        i++;
    } while (i < A.length);
    return -1;
}


