static String removeDuplicates (String s) {
    StringBuilder noDupes = new StringBuilder ();
    for (int i = 0;
    i < s.length (); i ++) {
        String si = s.substring (i, i + 1);
        if (noDupes.indexOf (si) == - 1) {
            noDupes.append (si);
        }
    }
    return noDupes.toString ();
}


 static String removeDuplicates (String s) {
    StringBuilder noDupes = new StringBuilder(s.length());
    boolean[] seen = new boolean[256];
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (seen[ch]) continue;
        noDupes.append(ch);
        seen[ch] = true;
    }
    return noDupes.toString();
}


