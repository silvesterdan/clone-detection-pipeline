public int solution (final int X, final int [] A) {
    Set < Integer > emptyPosition = new HashSet < Integer > ();
    for (int i = 1;
    i <= X; i ++) {
        emptyPosition.add (i);
    }
    for (int i = 0;
    i < A.length; i ++) {
        emptyPosition.remove (A [i]);
        if (emptyPosition.size () == 0) {
            return i;
        }
    }
    return - 1;
}


 

public int solution(int X, int[] A) {
    int[] emptyPosition = new int[X + 1];
    int sum = X;

    for (int i = 0; i < A.length; i++) {
        if (emptyPosition[A[i]] == 0) {
            emptyPosition[A[i]] = 1;
            sum--;
        }
        if (sum == 0) {
            return i;
        }
    }
    return -1;
}


