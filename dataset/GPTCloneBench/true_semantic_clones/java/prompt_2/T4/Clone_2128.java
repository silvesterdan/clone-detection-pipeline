public static void main (String [] args) {
    String word = "a b c";
    int i = 0, spaceCount = 0;
    while (i < word.length ()) {
        if (word.charAt (i) == ' ') {
            spaceCount ++;
        }
        i ++;
    }
    System.out.println ("Spaces in string: " + spaceCount);
}


 public static void main (String [] args) {
    int spaceCount = 0;
    for (int i = 0; i < args[0].length (); i++) {
        if (args[0].substring(i, i + 1).equals(" ")) {
            spaceCount ++;
        }
    }
    System.out.println ("Spaces in string: " + spaceCount);
}


