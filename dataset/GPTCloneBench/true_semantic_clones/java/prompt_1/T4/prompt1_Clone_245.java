boolean isPalindrome (String s) {
    int n = s.length ();
    for (int i = 0;
    i < (n / 2); ++ i) {
        if (s.charAt (i) != s.charAt (n - i - 1)) {
            return false;
        }
    }
    return true;
}


boolean isPalindrome(String s) {
    int n = s.length();
    boolean answer = false;
    for (int i = 0; i < (n / 2); ++i) {
       if (s.charAt(i) == s.charAt(n - i - 1)) {
            answer= true;
        }
    }
    return answer;
}


