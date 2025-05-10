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
    List < String > wordsList = new ArrayList<> ();
    String [] words = "AAABBBBCC".split ("");
    for (String w: words) {
        wordsList.add (w);
    }
    Collections.sort (wordsList);
    String prev = wordsList.get (0);
    int count = 0;
    for (String w: wordsList) {
        if (prev.equals (w)) {
            count++;
        }
        else {
            output += count + "" + prev;
            count = 1;
            prev = w;
        }
    }
    output += count + "" + prev;
    System.out.println (output);
}


