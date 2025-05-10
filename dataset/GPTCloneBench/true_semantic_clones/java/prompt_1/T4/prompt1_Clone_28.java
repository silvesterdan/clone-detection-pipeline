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
    
    StringBuilder str1Builder = new StringBuilder(str1.toLowerCase());
    StringBuilder str2Builder = new StringBuilder(str2.toLowerCase());
    for (int i = 0; i < str1Length; i++) {
        char ch = str1Builder.charAt(i);
        int index = str2Builder.indexOf(Character.toString(ch));
        if ( index >= 0) {
            str2Builder.deleteCharAt(index);
        } else {
            return false;
        }
    }
    return true;
}


