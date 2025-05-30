public static String interleave (String you, String me) {
    char [] a = you.toCharArray ();
    char [] b = me.toCharArray ();
    StringBuilder out = new StringBuilder ();
    int maxLength = Math.max (a.length, b.length);
    for (int i = 0;
    i < maxLength; i ++) {
        if (i < a.length) out.append (a [i]);
        if (i < b.length) out.append (b [i]);
    }
    return out.toString ();
}


 public static String interleave(String you, String me) {
    int maxLength = Math.max(you.length(), me.length());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < maxLength; i++) {
        if(i < you.length()) sb.append(you.charAt(i));
        if(i < me.length()) sb.append(me.charAt(i));
    }
    return sb.toString();
}


