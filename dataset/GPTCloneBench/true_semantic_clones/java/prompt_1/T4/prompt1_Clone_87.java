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


public static void main (String...a) {
    System.out.print("Enter the String");
    Scanner sc = new Scanner (System.in);
    String st = sc.nextLine();
    Map<Character, Integer> occurMap = new HashMap<>();
    for (int i = 0; i < st.length(); i++) {
        char c = st.charAt(i);
        occurMap.put(c, occurMap.containsKey(c) ? occurMap.get(c) + 1 : 1);
    }
    for (char c : occurMap.keySet()) {
        if (occurMap.get(c) == 1) {
            System.out.print(c);
        } else {
            System.out.print(c + "" + occurMap.get(c));
        }
    }
}


