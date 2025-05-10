static int findMIN (int [] A, int c) {
    int x = A [c];
    int position = c;
    while (c < A.length) {
        if (x > A [c]) {
            x = A [c];
            position = c;
        }
        c ++;
    }
    return position;
}


int findMIN (int [] A, int c) {
    int position = c;
    int x = A [c];
    for (int i=c; i<A.length; i++) {
        if (A [i] < x) {
            x = A [i];
            position = i;
        }
    }
    return position;
}


