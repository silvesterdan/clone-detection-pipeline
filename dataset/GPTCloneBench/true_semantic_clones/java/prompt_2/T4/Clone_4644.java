static int search (int [] A, int K) {
    int l = 0;
    int u = A.length - 1;
    int m;
    while (l <= u) {
        m = (u - l) / 2 + l;
        if (A [m] < K) l = m + 1;
        else if (A [m] == K) return m;
        else u = m - 1;
    }
    return - 1;
}




static int search(int[] A, int K) {
    java.util.List<Integer> list = java.util.Arrays.stream(A).boxed().collect(java.util.stream.Collectors.toList());
    return list.indexOf(K);
}


