public static boolean isAnagram (String first, String second) {
    String positive = first.toLowerCase ();
    String negative = second.toLowerCase ();
    if (positive.length () != negative.length ()) {
        return false;
    }
    int [] counts = new int [26];
    int diff = 0;
    for (int i = 0;
    i < positive.length (); i ++) {
        int pos = (int) positive.charAt (i) - 97;
        if (counts [pos] >= 0) {
            diff ++;
        } else {
            diff --;
        }
        counts [pos] ++;
        int neg = (int) negative.charAt (i) - 97;
        if (counts [neg] <= 0) {
            diff ++;
        } else {
            diff --;
        }
        counts [neg] --;
    }
    return diff == 0;
}



 

public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] ArrayS1 = s1.toLowerCase().toCharArray();
        char[] ArrayS2 = s2.toLowerCase().toCharArray();
        Arrays.sort(ArrayS1);
        Arrays.sort(ArrayS2);
        return Arrays.equals(ArrayS1, ArrayS2);
}


