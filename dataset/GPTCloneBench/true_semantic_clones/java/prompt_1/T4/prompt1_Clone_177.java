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
    Map < String, Integer > wordsMap = new HashMap<> ();
    String [] words = "AAABBBBCC".split ("");
    for (String word : words) {
        if (wordsMap.containsKey (word)) {
            Integer count = wordsMap.get(word);
            wordsMap.put (word, count + 1);
        }
        else {
            wordsMap.put (word, 1);
        }
    }
    for (Entry < String, Integer > entry : wordsMap.entrySet ()) {
        output += entry.getValue () + "" + entry.getKey ();
    }
    System.out.println (output);
}


