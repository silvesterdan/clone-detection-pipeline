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


public static void shuffleArray(int[] array) {
    int temp;
    for(int i=0; i<array.length-1; i++){
        int randomIndex = (int) Math.floor(Math.random() * array.length);
        temp = array[randomIndex];
        array[randomIndex] = array[i];
        array[i] = temp;
    }
}


