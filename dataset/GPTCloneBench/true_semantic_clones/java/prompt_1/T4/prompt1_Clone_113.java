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
    int j, temp;
    for (int i = list.size() - 1; i > 0; i--) {
        j = (int)(Math.random()*(i+1));  //random index from 0 to i
        temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    for (int i = 0;
    i < list.size (); i ++) {
        array [i] = list.get (i);
    }
}


