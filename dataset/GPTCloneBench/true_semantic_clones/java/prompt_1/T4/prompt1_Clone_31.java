public static boolean isPermutation (String str1, String str2) {
    char [] x = str1.toCharArray ();
    char [] y = str2.toCharArray ();
    Arrays.sort (x);
    Arrays.sort (y);
    if (Arrays.equals (x, y)) return true;
    return false;
}


public static boolean isPermutation (String str1, String str2) {
    int size1 = str1.length ();
    int size2 = str2.length ();

    if (size1 != size2) return false;

    char[] x = str1.toCharArray ();
    char[] y = str2.toCharArray ();

    Arrays.sort (x);
    Arrays.sort (y);

    for (int i=0; i<size1; i++)
        if (x[i] != y[i]) return false;

    return true;
}


