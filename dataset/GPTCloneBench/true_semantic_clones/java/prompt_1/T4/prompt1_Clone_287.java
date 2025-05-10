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
    if (values.length < 1) {
        return "";
    }
    char [] sep = separator.toCharArray();
    int totalLength = (values.length - 1) * sep.length;
    
    for (int i = 0; i < values.length; i++) {
        if (values[i] == null) {
            values[i] = "";
        }
        else {
            totalLength += values[i].length();
        }
    }
    
    char [] result = new char[totalLength];
    int position = 0;
    
    for (int i = 0, end = values.length - 1; i < end; i++) {
        String str = values[i];
        int length = str.length();
        str.getChars(0, length, result, position);
        position += length;
        
        System.arraycopy(sep, 0, result, position, sep.length);
        position += sep.length;
    }
    
    String lastStr = values[values.length - 1];
    lastStr.getChars(0, lastStr.length(), result, position);
    position += lastStr.length();
    
    return new String (result);
}


