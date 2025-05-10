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


public static String join (String delimiter, List <String> inStr) {
    StringBuilder sb = new StringBuilder ();
    Iterator <String> it = inStr.iterator ();
    if (it.hasNext ()) {
        sb.append (it.next ());
        while (it.hasNext ()) {
            sb.append (delimiter);
            sb.append (it.next ());
        }
    }
    return sb.toString ();
    
}


