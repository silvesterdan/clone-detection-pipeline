public static String join (String delimiter, String...inStr) {
    StringBuilder sb = new StringBuilder ();
    if (inStr.length > 0) {
        sb.append (inStr [0]);
        for (int i = 1;
        i < inStr.length; i ++) {
            sb.append (delimiter);
            sb.append (inStr [i]);
        }
    }
    return sb.toString ();
}


public static String join (String delimiter, String [] inStr) {
    StringBuilder sb = new StringBuilder ();
    for (int i = 0; i < inStr.length; i ++) {
        sb.append (inStr [i]);
        if (i != inStr.length -1)
        {
            sb.append (delimiter);
        }
    }
    return sb.toString ();
}


