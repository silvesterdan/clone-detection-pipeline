private String capitalizer (String word) {
    String [] words = word.split (" ");
    StringBuilder sb = new StringBuilder ();
    if (words [0].length () > 0) {
        sb.append (Character.toUpperCase (words [0].charAt (0)) + words [0].subSequence (1, words [0].length ()).toString ().toLowerCase ());
        for (int i = 1;
        i < words.length; i ++) {
            sb.append (" ");
            sb.append (Character.toUpperCase (words [i].charAt (0)) + words [i].subSequence (1, words [i].length ()).toString ().toLowerCase ());
        }
    }
    return sb.toString ();
}



 

private String capitalizer (String word) {
    String[] words = word.split(" ");
    for (int i = 0; i < words.length; i++) {
        words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
    }
    return String.join(" ", words);
}


