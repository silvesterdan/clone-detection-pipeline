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


public int solution(int X, int [] A) {
    int sum = 0;
    int searchedValue = X;
    int sumV = searchedValue * (searchedValue + 1) / 2;
    Map<Integer,Integer> map = new HashMap<>();
    for(int i = 0; i < A.length; i++) {
        if(A[i] <= searchedValue && !map.containsKey(A[i])) {
            sum += A[i];
            if(sum == sumV) {
                return i;
            }
            map.put(A[i],A[i]);
        }
    }
    return -1;
}
