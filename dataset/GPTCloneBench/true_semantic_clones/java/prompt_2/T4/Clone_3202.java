public int solution (int X, int [] A) {
    int size = A.length;
    int [] check = new int [X];
    int cmp = 0;
    int time = - 1;
    for (int x = 0;
    x < size; x ++) {
        int temp = A [x];
        if (temp <= X) {
            if (check [temp - 1] > 0) {
                continue;
            }
            check [temp - 1] ++;
            cmp ++;
        }
        if (cmp == X) {
            time = x;
            break;
        }
    }
    return time;
}




public int solution(int X, int[] A) {
    Set<Integer> distinct = new HashSet<Integer>();
    for (int i = 0; i < A.length ; i++) {
        if (A[i] <= X) distinct.add(A[i]);
        if (distinct.size() == X) return i;
    }
    return -1;
}


