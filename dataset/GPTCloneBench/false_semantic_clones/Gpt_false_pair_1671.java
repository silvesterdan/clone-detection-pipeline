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


 public static void main (String args[]) { 
    int i; 
    int large[] = new int[5]; 
    int array[] = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56}; 
    int grt = 0, pos; 
    for (int j = 0; j < 5; j++) { 
        grt = array[0]; 
        pos = 0; 
        for (i = 1; i < array.length; i++) { 
            if (array[i] > grt) { 
                grt = array[i]; 
                pos = i; 
            } 
        } 
        large[j] = grt; 
        array[pos] = Integer.MIN_VALUE; 
        System.out.println("Largest " + j + " : " + large[j]); 
    } 
}
