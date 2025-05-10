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


 public static void main(String[] args) { 
    String output = "";
    Multiset<String> wordsMultiset = ImmutableMultiset.copyOf(Arrays.asList("AAABBBBCC".split("")));
    for(String word : wordsMultiset.elementSet()) {
        if (!word.isEmpty()) output += wordsMultiset.count(word) + "" + word;
    }
    System.out.println(output);
}


