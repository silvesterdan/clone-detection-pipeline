public static void main (String [] args) {
    int large [] = new int [10];
    int array [] = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56};
    int k = 0;
    for (int i = 0;
    i < array.length; i ++) {
        large [k ++] = getMax (0, array);
    }
    System.out.println ("Largest 5 is: " + Arrays.toString (Arrays.copyOf (large, 5)));
}


 public static void main (String [] args) {
    int large [] = new int [10];
    int array [] = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56};
    
    for (int i = 0;
    i < 10; i++) {
        
        int max = array[0];
        int maxIndex = 0;
        for (int j = 0; j < array.length; j++) {
            if (max < array[j]) {
                max = array[j];
                maxIndex = j;
            }
        }
       
        large[i] = max; 
        array[maxIndex] = Integer.MIN_VALUE;
        
    }
    System.out.println ("Largest 5 is: " + Arrays.toString (Arrays.copyOf (large, 5)));
}


