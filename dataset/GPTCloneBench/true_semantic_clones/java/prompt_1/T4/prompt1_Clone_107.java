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


public static void  shuffleArray3(int [] array) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i : array)
        list.add(i);
        
    Collections.shuffle(list);
    int i = 0;
    for(Integer num : list)
        array[i++] = num;
}


