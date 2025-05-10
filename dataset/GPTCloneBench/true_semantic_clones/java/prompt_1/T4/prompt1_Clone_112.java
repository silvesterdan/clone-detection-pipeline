public static void shuffleArray (int [] array) {
    List < Integer > list = new ArrayList < > ();
    for (int i : array) {
        list.add (i);
    }
    Collections.shuffle (list);
    for (int i = 0;
    i < list.size (); i ++) {
        array [i] = list.get (i);
    }
}


public static void shuffleArray (int [] array) {
    List < Integer > list = new ArrayList < > ();
    for (int i : array) {
        list.add (i);
    }
    java.util.Random rnd = new java.util.Random();
    for (int i = list.size() - 1; i > 0; i--) {
        int index = rnd.nextInt(i + 1);
        int temp = list.get(index);
        list.set(index, list.get(i));
        list.set(i, temp);
    }
    for (int i = 0;
    i < list.size (); i ++) {
        array [i] = list.get (i);
    }
}


