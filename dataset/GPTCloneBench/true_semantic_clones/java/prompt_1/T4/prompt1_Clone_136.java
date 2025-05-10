public String nthShortWord (String [] words, int n) {
    int nthShortWord = 0;
    String shortWord = "notFound";
    for (int i = 0;
    i < words.length; i ++) {
        if (words [i].length () <= 3) nthShortWord ++;
        if (nthShortWord == n) {
            shortWord = nthShortWord [i];
            break;
        }
    }
    return shortWord;
}


public String nthShortWord (String [] words, int n) {
    int nthShortWord = 0;
    String shortWord = "notFound";
    int lenWords = words.length;
    for (int i = 0; i < lenWords; i++) {
        String currWord = words[i];
        int lengthCurrWord = currWord.length();
        if (lengthCurrWord <= 3) {
            nthShortWord ++;
            if (nthShortWord == n) {
                shortWord = currWord;
                break;
            }
        }
    }
    return shortWord;
}


