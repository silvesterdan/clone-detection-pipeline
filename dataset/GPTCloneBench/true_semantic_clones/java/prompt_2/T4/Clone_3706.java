public static void main (String...a) {
    System.out.print ("Enter the String");
    Scanner sc = new Scanner (System.in);
    String st = sc.nextLine ();
    int [] ar = new int [256];
    for (int i = 0;
    i < st.length (); i ++) {
        ar [st.charAt (i)] = ar [st.charAt (i)] + 1;
    }
    for (int i = 0;
    i < 256; i ++) {
        char ch = (char) i;
        if (ar [i] > 0) {
            if (ar [i] == 1) {
                System.out.print (ch);
            } else {
                System.out.print (ch + "" + ar [i]);
            }
        }
    }
}




public static void main (String args[] ) {
    System.out.print("Enter the String: ");
    Scanner sc = new Scanner (System.in);
    String str = sc.nextLine ();
    java.util.stream.IntStream.range(0, 256).forEach(i -> {
        long count = str.chars().filter(ch -> ch == i).count();
        if(count > 0)
            System.out.print((char)i);
    });
}


