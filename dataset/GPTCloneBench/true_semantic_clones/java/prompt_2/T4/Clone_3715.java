public static void main (String [] args) {
    HashMap < Character, Integer > hm = new HashMap < Character, Integer > ();
    System.out.println ("Enter an String:");
    Scanner sc = new Scanner (System.in);
    String s1 = sc.nextLine ();
    for (int i = 0;
    i < s1.length (); i ++) {
        if (! hm.containsKey (s1.charAt (i))) {
            hm.put (s1.charAt (i), (Integer) 1);
        } else {
            hm.put (s1.charAt (i), hm.get (s1.charAt (i)) + 1);
        }
    }
    System.out.println ("The Charecters are:" + hm);
}






public static void main(String[] args) {
    String s1 = new Scanner(System.in).nextLine();
    char[] chars = s1.toCharArray();
    SortedMap<Character, Integer> map = new TreeMap<>();
    for (char c : chars)
        map.merge(c, 1, Integer::sum);
    System.out.println(map);
}


