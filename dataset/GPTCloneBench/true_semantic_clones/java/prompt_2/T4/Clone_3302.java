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





public int solution(int X, int[] A) {
    int sum1 = IntStream.rangeClosed(0, X).sum();
    Set<Integer> set = new HashSet<>();
    int sum2 = 0;
    for (int i = 0; i < A.length && sum2 < sum1; i++) {
        if (set.add(A[i])) sum2 += A[i];
        if (sum2 == sum1) return i;
    }
    return -1;
}


