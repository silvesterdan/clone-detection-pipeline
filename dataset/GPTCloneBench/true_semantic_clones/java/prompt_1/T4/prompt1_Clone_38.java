public static boolean isAnagram (String s1, String s2) {
    if (s1.length () != s2.length ()) {
        return false;
    }
    s1 = s1.toLowerCase ();
    s2 = s2.toLowerCase ();
    char [] c1 = s1.toCharArray ();
    char [] c2 = s2.toCharArray ();
    Arrays.sort (c1);
    Arrays.sort (c2);
    String sc1 = new String (c1);
    String sc2 = new String (c2);
    return sc1.equals (sc2);
}


public static boolean isAnagram3 (String s1, String s2) {
    if (s1.length () != s2.length ()) {
        return false;
    }
    s1 = s1.toLowerCase ();
    s2 = s2.toLowerCase ();
    char [] c1 = s1.toCharArray ();
    char [] c2 = s2.toCharArray ();
    int [] c1count = new int[256];
    int [] c2count = new int[256];
    for (char c: c1) {
        c1count[c]++;
    }
    for (char c: c2) {
        c2count[c]++;
    }
    for (int i = 0; i < 256; i++) {
        if (c1count[i] != c2count[i]) {
            return false;
        }
    }
    return true;
}


