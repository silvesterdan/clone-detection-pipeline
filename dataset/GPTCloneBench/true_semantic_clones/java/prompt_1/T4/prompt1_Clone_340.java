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
    for (int j = 1;
    j < 16; ++ j) {
        if ((j % 4) < 1) System.out.print ("A");
        if ((j % 8) < 3) System.out.print ("B");
        if ((j % 16) < 7) System.out.print ("C");
        if ((j % 32) < 15) System.out.print ("D");
        System.out.println ("");
    }
}


