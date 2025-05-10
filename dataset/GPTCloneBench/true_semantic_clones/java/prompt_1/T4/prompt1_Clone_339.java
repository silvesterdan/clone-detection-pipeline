public static void main (String [] args) {
    for (int i = 1;
    i < 16; ++ i) {
        if ((i & 1) > 0) System.out.print ("A");
        if ((i & 2) > 0) System.out.print ("B");
        if ((i & 4) > 0) System.out.print ("C");
        if ((i & 8) > 0) System.out.print ("D");
        System.out.println ("");
    }
}


public static void main (String [] args) {
    for (int x = 1;
    x < 16; ++ x) {
        if ((x % 2) > 0) System.out.print ("A");
        if ((x % 4) > 1) System.out.print ("B");
        if ((x % 8) > 3) System.out.print ("C");
        if ((x % 16) > 7) System.out.print ("D");
        System.out.println ("");
    }
}


