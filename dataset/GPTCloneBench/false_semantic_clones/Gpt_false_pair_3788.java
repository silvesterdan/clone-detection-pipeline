public static void main (String args []) {
    int i;
    int large [] = new int [5];
    int array [] = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56};
    int max = 0, index;
    for (int j = 0;
    j < 5; j ++) {
        max = array [0];
        index = 0;
        for (i = 1; i < array.length; i ++) {
            if (max < array [i]) {
                max = array [i];
                index = i;
            }
        }
        large [j] = max;
        array [index] = Integer.MIN_VALUE;
        System.out.println ("Largest " + j + " : " + large [j]);
    }
}


public static void main (String args []) {
    int i;
    int arrLarge [] = new int [5];
    int arr [] = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56};
    int large = 0, dex;
    for (int j = 0;
    j < 5; j ++) {
        large = arr [0];
        dex = 0;
        for (i = 1; i < arr.length; i ++) {
            if (large < arr [i]) {
                large = arr [i];
                dex = i;
            }
        }
        arrLarge [j] = large;
        arr [dex] = Integer.MIN_VALUE;
        System.out.println ("Largest " + j + " : " + arrLarge [j]);
    }
}
