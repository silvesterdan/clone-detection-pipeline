static int [] sort (int arr []) {
    for (int i = 0;
    i < arr.length; i ++) {
        for (int j = i;
        j < arr.length; j ++) {
            if (arr [j] < arr [i]) {
                int temp = arr [i];
                arr [i] = arr [j];
                arr [j] = temp;
            }
        }
    }
    return arr;
}



public static int[] sort(int[] arr) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int num: arr) {
        pq.add(num);
    }
    int i = 0;
    while(!pq.isEmpty()){
        arr[i++] = pq.poll();
    }
    return arr;
}


