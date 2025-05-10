public static String join (String separator, String...values) {
    if (values.length == 0) return "";
    char [] sep = separator.toCharArray ();
    int totalSize = (values.length - 1) * sep.length;
    for (int i = 0;
    i < values.length; i ++) {
        if (values [i] == null) values [i] = "";
        else totalSize += values [i].length ();
    }
    char [] joined = new char [totalSize];
    int pos = 0;
    for (int i = 0, end = values.length - 1;
    i < end; i ++) {
        System.arraycopy (values [i].toCharArray (), 0, joined, pos, values [i].length ());
        pos += values [i].length ();
        System.arraycopy (sep, 0, joined, pos, sep.length);
        pos += sep.length;
    }
    System.arraycopy (values [values.length - 1].toCharArray (), 0, joined, pos, values [values.length - 1].length ());
    return new String (joined);
}


public static String join(String separator, String...values) {
    if (values.length == 0) {
        return "";
    }
    char[] sep = separator.toCharArray();
    int totalSize = (values.length - 1) * sep.length;
    
    for (int i = 0; i < values.length; i++) {
        if (values[i] == null) {
            values[i] = "";
        }
        else {
            totalSize += values[i].length();
        }
    }
    char[] joined = new char[totalSize];
    int pos = 0;
    
    for (int i = 0, end = values.length - 1; i < end; i++) {
        String str = values[i];
        int length = str.length();
        for (int j = 0; j < length; j++) {
            joined[pos] = str.charAt(j);
            pos++;
        }
        for (int k = 0; k < sep.length; k++) {
            joined[pos] = sep[k];
            pos++;
        }
    }
    
    String lastStr = values[values.length - 1];
    int len = lastStr.length();
    for (int j = 0; j < len; j++) {
        joined[pos] = lastStr.charAt(j);
        pos++;
    }
    return new String (joined);
}


