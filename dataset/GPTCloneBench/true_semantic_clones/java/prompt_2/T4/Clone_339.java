public int solution (int X, int [] A) {
    Set < Integer > set = new HashSet < Integer > ();
    int sum1 = 0, sum2 = 0;
    for (int i = 0;
    i <= X; i ++) {
        sum1 += i;
    }
    for (int i = 0;
    i < A.length; i ++) {
        if (set.contains (A [i])) continue;
        set.add (A [i]);
        sum2 += A [i];
        if (sum1 == sum2) return i;
    }
    return - 1;
}


 public int solution (int X, int [] A) {
    boolean[] seen = new boolean[X + 1];
    int sum1 = 0, sum2 = 0;
    for (int i = 0;
    i <= X; i ++) {
        sum1 = sum1 + i;
        seen[i] = true;
    }
    for (int i = 0;
    i < A.length; i ++) {
        if (seen[A[i]] == true) {
            continue;
        }
        seen[A[i]] = false;
        sum2 = sum2 + A[i];
        if (sum1 == sum2) {
            return i;
        }
    }
    return - 1;
}


