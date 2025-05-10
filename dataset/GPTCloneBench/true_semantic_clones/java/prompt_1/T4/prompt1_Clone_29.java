public static boolean isPermutation (String str1, String str2) {
    char [] x = str1.toCharArray ();
    char [] y = str2.toCharArray ();
    Arrays.sort (x);
    Arrays.sort (y);
    if (Arrays.equals (x, y)) return true;
    return false;
}


public static boolean isPermutation (String str1, String str2) {
    int str1Length = str1.length();
    int str2Length = str2.length();
    if (str1Length != str2Length) return false;
    
    char[] x = str1.toCharArray ();
    char[] y = str2.toCharArray ();
    Arrays.sort (x);
    Arrays.sort (y);
    int l = x.length;
    for (int i=0; i<l; i++) {
        if (x[i] != y[i]) return false;
    }
    return true;
}


