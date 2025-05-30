public static void main (String [] args) {
    List < Animal > list1 = new LinkedList < > (Arrays.asList (Cat, Mouse, Dog));
    List < Animal > list2 = new LinkedList < > (Arrays.asList (Dog, Mouse, Cat));
    List < Animal > list3 = new LinkedList < > (Arrays.asList (Dog, Horse, Cat));
    List < Animal > list4 = new LinkedList < > (Arrays.asList (Dog, Tiger, Lion));
    List < List < Animal > > list = new LinkedList < > (Arrays.asList (list1, list2, list3, list4));
    Set < List < Animal > > sorted = new LinkedHashSet < > ();
    for (List < Animal > animals : list) {
        List < Animal > arList = new ArrayList < > (animals);
        Collections.sort (arList);
        sorted.add (new LinkedList < > (arList));
    }
    for (List < Animal > animals : sorted) {
        System.out.println (animals);
    }
}


 public static void main (String [] args) { 
    List < Animal > list1 = new Stack<>(Arrays.asList(Cat, Mouse, Dog));
    List < Animal > list2 = new Stack<>(Arrays.asList(Dog, Mouse, Cat));
    List < Animal > list3 = new Stack<>(Arrays.asList(Dog, Horse, Cat));
    List < Animal > list4 = new Stack<>(Arrays.asList(Dog, Tiger, Lion));
    List< List < Animal > > list = new Stack<>(Arrays.asList(list1, list2, list3, list4));
    Set < List < Animal > > sorted = new LinkedHashSet < > ();
    for (List < Animal > animals : list) {
        List< Animal > arList = new Vector<>(animals);
        Collections.sort (arList);
        sorted.add (new Stack<>(arList));
    }
    for (List < Animal > animals : sorted) {
        System.out.println (animals);
    }
}
