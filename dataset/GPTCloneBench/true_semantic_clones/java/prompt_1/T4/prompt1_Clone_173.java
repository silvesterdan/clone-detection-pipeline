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
    wordsMap.put ("A", 3);
    wordsMap.put ("B", 4);
    wordsMap.put ("C", 2);
    for (Entry < String, Integer > string : wordsMap.entrySet ()) {
        if (! string.getKey ().isEmpty ()) output += string.getValue () + "" + string.getKey ();
    }
    System.out.println (output);
}


