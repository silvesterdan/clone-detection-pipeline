public int solution (int X, int [] A) {
    int list [] = A;
    int sum = 0;
    int searchedValue = X;
    int sumV = searchedValue * (searchedValue + 1) / 2;
    List < Integer > arrayList = new ArrayList < Integer > ();
    for (int iii = 0;
    iii < list.length; iii ++) {
        if (list [iii] <= searchedValue && ! arrayList.contains (list [iii])) {
            sum += list [iii];
            if (sum == sumV) {
                return iii;
            }
            arrayList.add (list [iii]);
        }
    }
    return - 1;
}




public int solution(int X, int[] A) {
    boolean[] check = new boolean[X + 1];
    int sum = (1 + X) * X / 2;
    for (int i = 0; i < A.length; i++) {
        if (!check[A[i]]) {
            check[A[i]] = true;
            sum -= A[i];
            if (sum == 0) {
                return i;
            }
        }
    }
    return -1;
}


