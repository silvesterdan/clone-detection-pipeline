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
    List < String > wordsList = new ArrayList <> ();
    String [] words = "AAABBBBCC".split ("");
    wordsList.addAll (Arrays.asList (words));
    Map < String , Integer > wordsMap = new HashMap <> ();
    for (String s : wordsList) {
        if (wordsMap.containsKey (s)) wordsMap.put (s , wordsMap.get (s) + 1); 
        else wordsMap.put (s , 1);
    }
    for (Map.Entry < String , Integer > string : wordsMap.entrySet ()) {
        if (! string.getKey ().isEmpty ()) output += string.getValue () + "" + string.getKey ();
    }
    System.out.println (output);
}


