public static void main (String [] args) {
    String needle = "ABC";
    String haystack = "ABCDSGDABCSAGAABCCCCAAABAABC";
    int numberOfOccurences = 0;
    int index = haystack.indexOf (needle);
    while (index != - 1) {
        numberOfOccurences ++;
        haystack = haystack.substring (index + needle.length ());
        index = haystack.indexOf (needle);
    }
    System.out.println ("" + numberOfOccurences);
}


 public static void main(String[] args) {
    String needle = "ABC";
    String haystack = "ABCDSGDABCSAGAABCCCCAAABAABC";
    int numberOfOccurrences = 0;
    int startIndex = 0;
    while(true) {
        int temp = haystack.indexOf(needle, startIndex);
        if(temp < 0) {
            break;
        } 
        startIndex = temp + 1;
        numberOfOccurrences++;
    }
    System.out.println(numberOfOccurrences);
}

