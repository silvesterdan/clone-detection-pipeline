public static int mode (int [] [] arr) {
    List < Integer > list = new ArrayList < Integer > ();
    for (int i = 0;
    i < arr.length; i ++) {
        for (int j = 0;
        j < arr [i].length; j ++) {
            list.add (arr [i] [j]);
        }
    }
    int [] vector = new int [list.size ()];
    for (int i = 0;
    i < vector.length; i ++) {
        vector [i] = list.get (i);
    }
}



 public static int mode(int[][] arr) {
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<arr.length; i++) {
        for(int j=0; j<arr[i].length; j++) {
            list.add(arr[i][j]);
        }
    }

    int mode = 0;
    Map<Integer, Integer> counts = new HashMap<>();
    for (Integer value : list) {
        if (counts.containsKey(value)) {
            counts.put(value, counts.get(value) + 1);
        } else {
            counts.put(value, 1);
        }
        if (counts.get(value) > mode) {
            mode = value;
        }
    }
    return mode;
}

