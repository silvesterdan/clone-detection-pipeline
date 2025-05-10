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
    Set <String> noDupes = new HashSet<>();
    for (int i = 0; i < s.length (); i ++) {
        String ch = String.valueOf(s.charAt(i));
        noDupes.add(ch);
    }
    return String.join("", noDupes);
}


