public static void main (String args []) {
    inp = new Scanner (System.in);
    String str = inp.nextLine ();
    List < Character > arrlist = new ArrayList < Character > ();
    for (int i = 0;
    i < str.length (); i ++) {
        arrlist.add (str.charAt (i));
    }
    for (int i = 0;
    i < str.length (); i ++) {
        int freq = Collections.frequency (arrlist, str.charAt (i));
        System.out.println ("Frequency of " + str.charAt (i) + "  is:   " + freq);
    }
}


public static void main (String args []) {
    inp = new Scanner (System.in);
    String str = inp.nextLine ();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0;
    i < str.length (); i ++) {
        char c = str.charAt(i);
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }
    for (int i = 0;
    i < str.length (); i ++) {
        int freq = map.get(str.charAt(i));
        System.out.println ("Frequency of " + str.charAt (i) + "  is:   " + freq);
    }
}


