public static boolean isAnagram (String s1, String s2) {
    if (s1.length () != s2.length ()) {
        return false;
    }
    s1 = s1.toLowerCase ();
    s2 = s2.toLowerCase ();
    char [] c1 = s1.toCharArray ();
    char [] c2 = s2.toCharArray ();
    Arrays.sort (c1);
    Arrays.sort (c2);
    String sc1 = new String (c1);
    String sc2 = new String (c2);
    return sc1.equals (sc2);
}


public static boolean isAnagram (String s1, String s2){
    if(s1.length() != s2.length()){
        return false;
    }
    char letter1[] = s1.toLowerCase().toCharArray();
    char letter2[] = s2.toLowerCase().toCharArray();
    HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
    HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
    
    for(Character c : letter1) {
        if(map1.containsKey(c)){
            map1.put(c, map1.get(c)+1);
        } else {
            map1.put(c, 1);
        }
    }
    
    for(Character c : letter2) {
        if(map2.containsKey(c)){
            map2.put(c, map2.get(c)+1);
        } else {
            map2.put(c, 1);
        }
    }
    
    for(Character c : map1.keySet()) {
        if(map2.containsKey(c)) {
            if(map1.get(c) == map2.get(c)){
                continue;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    return true;
}


