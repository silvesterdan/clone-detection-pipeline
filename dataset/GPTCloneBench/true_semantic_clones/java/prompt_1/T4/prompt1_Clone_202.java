private static char findFirstCharacter (String s) {
    HashSet < Character > unique = new LinkedHashSet < > (), seen = new HashSet < > ();
    for (int i = 0;
    i < s.length (); i ++) {
        char c = s.charAt (i);
        if (seen.add (c)) unique.add (c);
        else unique.remove (c);
    }
    return unique.isEmpty () ? '_' : unique.iterator ().next ();
}


private static char findFirstCharacter(String s) {
    Map<Character, Integer> charFreq = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        int count = charFreq.getOrDefault(c, 0);
        charFreq.put(c, count + 1);
    }
    
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (charFreq.get(c) == 1) return c;
    }
    return '_';
}


