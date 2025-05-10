public static int countLines (String str) {
    if (str == null || str.isEmpty ()) {
        return 0;
    }
    int lines = 1;
    int pos = 0;
    while ((pos = str.indexOf ("\n", pos) + 1) != 0) {
        lines ++;
    }
    return lines;
}


 public static int countLines (String str) {
    if (str == null || str.isEmpty ()) {
        return 0;
    }
    int lines = 0;
    int pos = 0;
    while (pos >= 0) {
        int prevPos = pos;
        pos = str.indexOf("\n", prevPos);
        if (pos >= 0) {
            lines++;
            pos++;
        }
        else {
            return lines;
        }
    }
    return lines;
}


