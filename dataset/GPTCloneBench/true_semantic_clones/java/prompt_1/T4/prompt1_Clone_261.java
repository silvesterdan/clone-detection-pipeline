public static String merge (String...strings) {
    int maxLength = 0;
    StringBuilder sb = new StringBuilder ();
    for (String s : strings) if (s.length () > maxLength) maxLength = s.length ();
    for (int i = 0;
    i < maxLength; i ++) for (String s : strings) if (s.length () > i) sb.append (s.charAt (i));
    return sb.toString ();
}


public static String mergeT3 (String...strings) {
    int maxLength = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strings.length; i++) {
        if (strings[i].length() > maxLength) {
            maxLength = strings[i].length();
        }
    }
    for (int i = 0; i < maxLength; i++) {
        for (int j = 0; j < strings.length; j++) {
            if (strings[j].length() > i) {
                sb.append(strings[j].charAt(i));
            }
        }
    }
    return sb.toString();
}


