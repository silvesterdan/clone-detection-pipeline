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


public static void  shuffleArray2(int [] array) {
    Integer[] newArray = new Integer[array.length];
    for (int i = 0; i < array.length; i++) {
        newArray[i] = array[i];
    }
    Collections.shuffle(Arrays.asList(newArray));
    for (int i = 0; i < newArray.length; i++) {
        array[i] = newArray[i];
    }
}


