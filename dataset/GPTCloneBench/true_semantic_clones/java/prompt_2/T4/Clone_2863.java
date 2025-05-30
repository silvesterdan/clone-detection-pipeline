public static boolean isAnagram (String s1, String s2) {
    if (s1.length () != s2.length ()) {
        return false;
    }
    for (int i = 0;
    i < s2.length (); i ++) {
        if (! s1.contains ("" + s2.charAt (i))) {
            return false;
        }
        s1 = s1.replaceFirst ("" + s2.charAt (i), "");
        s2 = s2.replaceFirst ("" + s2.charAt (i), "");
    }
    return true;
}




public static boolean isAnagram(String s1, String s2) {
    char[] charArr1 = s1.toCharArray();
    char[] charArr2 = s2.toCharArray();
    Arrays.sort(charArr1);
    Arrays.sort(charArr2);
    return Arrays.equals(charArr1, charArr2);
}


