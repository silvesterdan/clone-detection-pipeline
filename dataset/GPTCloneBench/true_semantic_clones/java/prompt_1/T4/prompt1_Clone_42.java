public static int solution (int X, int [] A) {
    Set < Integer > values = new HashSet < Integer > ();
    for (int i = 0;
    i < A.length; i ++) {
        if (values.add (A [i])) X --;
        if (X == 0) return i;
    }
    return - 1;
}


public static int solution (int X, int [] A) {
    Set < Integer > values = new HashSet < Integer > ();
    int res = -1;
    for (int i = 0; i < A.length; i ++) {
        if (values.add (A [i]) && X == 0) 
            res = i;
        else 
            X--;
    }
    return res;
}


