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
    int [] arr = new int[X + 1];
    for (int i = 0;
    i < A.length; i ++) {
        if (A [i] <= X) arr [A[i]] = 1;
        int sum = 0;
        for (int j = 1; j <= X; j++)
            sum += arr[j];
        if (sum == X) return i;
    }
    return - 1;
}


