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
    String processedS1 = s1.toLowerCase().replaceAll(" ", "");
    String processedS2 = s2.toLowerCase().replaceAll(" ", "");
    return processedS1.length() == processedS2.length() && processedS1.chars().sum() == processedS2.chars().sum();
}


