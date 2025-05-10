public int solution (int X, int [] A) {
    int len = A.length;
    if (X > len) {
        return - 1;
    }
    int [] isFilled = new int [X];
    int jumped = 0;
    Arrays.fill (isFilled, 0);
    for (int i = 0;
    i < len; i ++) {
        int x = A [i];
        if (x <= X) {
            if (isFilled [x - 1] == 0) {
                isFilled [x - 1] = 1;
                jumped += 1;
                if (jumped == X) {
                    return i;
                }
            }
        }
    }
    return - 1;
}


 
public int solution (int X, int [] A) {
    int len = A.length;
    if (len <= X) {
        return -1;
    }
    int jumped = 0;
    boolean [] isFilled = new boolean [X];
    for (int i = 0; i < len; i++) {
        int x = A[i];
        if (x <= X && !isFilled[x-1]) {
            isFilled[x-1] = true;
            jumped++;
            if(jumped == X)
                return i;
        }
    }
    return -1; 
}


