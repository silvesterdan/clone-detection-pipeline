public static void main (String [] args) {
    String output = "";
    Multiset < String > wordsMultiset = HashMultiset.create ();
    String [] words = "AAABBBBCC".split ("");
    wordsMultiset.addAll (Arrays.asList (words));
    for (Entry < String > string : wordsMultiset.entrySet ()) {
        if (! string.getElement ().isEmpty ()) output += string.getCount () + "" + string.getElement ();
    }
    System.out.println (output);
}


public static void main (String [] args) {
    String output = "";
    Map < String, Integer > wordsMap = new HashMap < String, Integer > ();
    String [] words = "AAABBBBCC".split ("");
    for (String word : words) {
        Integer count = wordsMap.get (word);
        if (count == null)
            wordsMap.put (word, 1);
        else
            wordsMap.put (word, count + 1);
    }
    for (Map.Entry < String, Integer > string : wordsMap.entrySet ()) {
        if (! string.getKey ().isEmpty ()) 
            output += string.getValue () + "" + string.getKey ();
    }
    System.out.println (output);
}


