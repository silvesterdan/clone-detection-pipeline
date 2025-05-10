public int solution (int X, int [] A) {
    HashSet < Integer > hset = new HashSet < Integer > ();
    for (int i = 0;
    i < A.length; i ++) {
        if (A [i] <= X) hset.add (A [i]);
        if (hset.size () == X) return i;
    }
    return - 1;
}


public int solution (int X, int [] A) {
    BitSet bset = new BitSet (X + 1);
    for (int i = 0;
    i < A.length; i ++) {
        if (A [i] <= X) bset.set (A[i]);
        int sum = 0;
        for (int j = 0; j <= X; j++)
            sum += bset.get(j) ? 1 : 0;
        if (sum == X) return i;
    }
    return - 1;
}


