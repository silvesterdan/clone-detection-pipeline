public static void main (String args []) {
    int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    System.out.println ("Enter the number of elements: ");
    Scanner sc = new Scanner (System.in);
    int [] arr = new int [sc.nextInt ()];
    System.out.println ("Enter the elements: ");
    for (int i = 0;
    i < arr.length; i ++) {
        int next = sc.nextInt ();
        arr [i] = next;
    }
    for (int j = 0;
    j < arr.length; j ++) {
        if (arr [j] > max) max = arr [j];
        else if (arr [j] < min) min = arr [j];
    }
    System.out.println ("Highest Value in array: " + max);
    System.out.println ("Smallest Value in array: " + min);
}




public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    List<Integer> numbers = new ArrayList<>();
    int n = sc.nextInt();
    System.out.println("Enter the elements: ");
    for(int i=0; i<n; i++) numbers.add(sc.nextInt());
    Integer max = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
    Integer min = numbers.stream().reduce(Integer.MAX_VALUE, Integer::min);
    System.out.println("Highest value in the array: "+max);
    System.out.println("Lowest value in the array: "+min);
}


