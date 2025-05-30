public static void main (String [] args) {
    int large [] = new int [10];
    int array [] = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56};
    int k = 0;
    for (int i = 0;
    i < array.length; i ++) {
        large [k ++] = getMax (0, array);
    }
    System.out.println ("Largest 5 is: " + Arrays.toString (Arrays.copyOf (large, 5)));
}





public static void main(String[] args) {
    int[] numbers = {33, 55, 13, 46, 87, 42, 10, 34, 43, 56};
    PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());
    for (int num : numbers) {
        queue.add(num);
    }
    int[] top5 = new int[5];
    for (int i = 0; i < 5; i++) {
        top5[i] = queue.poll();
    }
    System.out.println("Largest 5 is: " + Arrays.toString(top5));
}


