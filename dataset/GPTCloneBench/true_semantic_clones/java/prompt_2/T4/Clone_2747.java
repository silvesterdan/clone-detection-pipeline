public String longestSequenceOfChar (String str) {
    String interimresult = "";
    String result = "";
    for (int i = 0;
    i < str.length (); i ++) {
        char ch = str.charAt (i);
        interimresult += ch;
        for (int j = i + 1;
        j < str.length (); j ++) {
            char ch1 = str.charAt (j);
            if (ch != ch1) {
                break;
            }
            interimresult += ch;
        }
        if (interimresult.length () > result.length ()) result = interimresult;
        interimresult = "";
    }
    return result;
}




public String longestSequenceOfChar (String str) {
    String result = "";
    for (int i = 0; i < str.length(); i++) {
        int j = i;
        while (j < str.length() && str.charAt(i) == str.charAt(j)) j++;
        if (j - i > result.length()) result = str.substring(i, j);
    }
    return result;
}


