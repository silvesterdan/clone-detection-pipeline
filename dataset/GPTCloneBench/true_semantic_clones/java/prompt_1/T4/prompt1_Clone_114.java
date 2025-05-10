public static final void printArray (int [] arr) {
    System.out.print ("[");
    for (int i = 0;
    i < arr.length; i ++) {
        if (i == arr.length - 1) System.out.print (arr [i]);
        else System.out.print (arr [i] + ", ");
    }
    System.out.println ("]");
}


public static final void printArray (int [] arr) {
    String output = "[";
    for (int i = 0; i < arr.length; i ++) {
        if (i == arr.length - 1) output += arr [i];
        else output += arr [i] + ", ";
    }
    output += "]";
    System.out.println(output);
}


