public static boolean isPalindrome (String str) {
    str = str.toUpperCase ();
    char [] strChars = str.toCharArray ();
    List < Character > word = new ArrayList < > ();
    for (char c : strChars) {
        word.add (c);
    }
    while (true) {
        if ((word.size () == 1) || (word.size () == 0)) {
            return true;
        }
        if (word.get (0) == word.get (word.size () - 1)) {
            word.remove (0);
            word.remove (word.size () - 1);
        } else {
            return false;
        }
    }
}





public static boolean isPalindrome (String str) {
    str = str.toUpperCase ();
    for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
        if (str.charAt(i) != str.charAt(j)) return false;
    }
    return true;
}


