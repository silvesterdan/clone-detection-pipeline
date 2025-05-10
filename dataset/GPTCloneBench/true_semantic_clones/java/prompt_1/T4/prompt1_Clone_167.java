public static int [] front11 (int [] a, int [] b) {
    int alen = (a != null) ? a.length : 0, blen = (b != null) ? b.length : 0;
    if (alen > 0 && blen > 0) {
        return new int [] {a [0], b [0]};
    } else if (alen > 0) {
        return new int [] {a [0]};
    } else if (blen > 0) {
        return new int [] {b [0]};
    } else {
        return new int [0];
    }
}


public static int[] front11(int[] a, int[] b) {
    int alen = a != null ? a.length : 0;
    int blen = b != null ? b.length : 0;

    if(alen > 0 && blen > 0) {
        int[] retArr = new int[2];
        retArr[0] = a[0];
        retArr[1] = b[0];
        return retArr;
    } else if(alen > 0) {
        int[] retArr = new int[1];
        retArr[0] = a[0];
        return retArr;
    } else if(blen > 0) {
        int[] retArr = new int[1];
        retArr[0] = b[0];
        return retArr;
    } else {
        return new int[0];
    }
}


