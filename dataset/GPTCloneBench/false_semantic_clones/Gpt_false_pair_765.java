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
    int n, maximum = Integer.MIN_VALUE, minimum = Integer.MAX_VALUE;
    System.out.println ("Enter the number of elements: ");
    Scanner sc = new Scanner (System.in);
    int len = sc.nextInt ();
    int [] arr = new int [len];
    System.out.println ("Enter the elements: ");
    for (int i = 0;
    i < arr.length; i ++) {
        arr [i] = sc.nextInt ();
    }
    for (int j = 0; j < arr.length; j ++) {
        if (arr[j] > maximum) 
            maximum = arr [j];
        else if (arr [j] < minimum) 
            minimum = arr [j];
    }
    System.out.println ("Highest Value in array: " + maximum);
    System.out.println ("Smallest Value in array: " + minimum);
}
