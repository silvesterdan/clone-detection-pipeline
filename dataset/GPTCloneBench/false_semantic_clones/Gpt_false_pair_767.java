public static void main (String args []) {
    int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    System.out.println ("Enter the number of elements: ");
    Scanner sc = new Scanner (System.in);
    int [] arr = new int [sc.nextInt ()];
    System.out.println ("Enter the elements: ");
    for (int i = 0;
    i < arr.length; i ++) {
        int next = sc.nextInt ();
        arr [i] = next;
    }
    for (int j = 0;
    j < arr.length; j ++) {
        if (arr [j] > max) max = arr [j];
        else if (arr [j] < min) min = arr [j];
    }
    System.out.println ("Highest Value in array: " + max);
    System.out.println ("Smallest Value in array: " + min);
}


 public static void main (String args []) {
    int n, maxNumber = Integer.MIN_VALUE, lowestNumber = Integer.MAX_VALUE;
    System.out.println ("Enter the number of elements: ");
    Scanner sc = new Scanner (System.in);
    int arrayLength = sc.nextInt ();
    int [] arrayFull = new int [arrayLength];
    System.out.println ("Enter the elements: ");
    for (int i = 0;
    i < arrayFull.length; i ++) {
        arrayFull [i] = sc.nextInt ();
    }
    for (int j = 0; j < arrayFull.length; j ++) {
        if (arrayFull [j] > maxNumber) 
            maxNumber = arrayFull [j];
        else if (arrayFull [j] < lowestNumber) 
            lowestNumber = arrayFull [j];
    }
    System.out.println ("Highest Value in array: " + maxNumber);
    System.out.println ("Smallest Value in array: " + lowestNumber);
}
