public static String center (String s, int size, char pad) {
    if (s == null || size <= s.length ()) return s;
    StringBuilder sb = new StringBuilder (size);
    for (int i = 0;
    i < (size - s.length ()) / 2; i ++) {
        sb.append (pad);
    }
    sb.append (s);
    while (sb.length () < size) {
        sb.append (pad);
    }
    return sb.toString ();
}


public static String center (String s, int size, char pad) {
    if (s == null || s.length() >= size)
        return s;

    int left = (size - s.length ()) / 2;
    int right = size - s.length () - left;

    StringBuilder sb = new StringBuilder(size);

    for (int i = 0; i < left; i++)
        sb.append(pad);
    
    sb.append(s);

    for (int i = 0; i < right; i++)
        sb.append(pad);

    return sb.toString();
}


