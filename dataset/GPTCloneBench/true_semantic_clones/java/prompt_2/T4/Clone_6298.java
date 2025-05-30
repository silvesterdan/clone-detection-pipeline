public static String numLetters (String s) {
    int [] count = new int [26];
    for (int i = 0;
    i < s.length (); i ++) {
        char c = s.charAt (i);
        count [(int) (c - 'a')] ++;
    }
    String ans = "";
    for (int i = 0;
    i < 26; i ++) {
        if (count [i] != 0) {
            ans += String.valueOf (count [i]) + (char) (i + 'a');
        }
    }
    return ans;
}





public static String numLetters(String s) {
    StringBuilder ans = new StringBuilder();
    s.chars().distinct().sorted()
        .forEach(c -> ans.append((int)s.chars().filter(ch -> ch == c).count()).append((char)c));
    return ans.toString();
}


