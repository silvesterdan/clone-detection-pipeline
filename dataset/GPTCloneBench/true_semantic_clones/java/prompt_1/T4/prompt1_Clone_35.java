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


public static boolean isAnagram (String s1, String s2) {
    if (s1.length() != s2.length()) {
        return false;
    }
    int[] checker = new int[26];
    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();
    for (int i = 0; i < s1.length(); i++) {
        checker[s1.charAt(i) - 'a']++;
        checker[s2.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
        if (checker[i] != 0) {
            return false;
        }
    }
    return true;
}


