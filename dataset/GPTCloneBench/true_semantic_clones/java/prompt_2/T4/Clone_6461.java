public static void main (String [] args) {
    int [] [] matrix = new int [] [] {{1, 2, 2}, {2, 2, 3}, {0, 1, 2}};
    int result = 1;
    for (int i = 0;
    i < matrix.length; i ++) {
        result = result * matrix [i] [i];
    }
    System.out.println ("Result: " + result);
}





public static void main (String[] args) {
    int[][] nums = {{1, 2, 2}, {2, 2, 3}, {0, 1, 2}};
    int val = 1;
    for (int i = 0; i < nums.length; i ++)
        val *= nums[i][i];
    System.out.println ("Val: " + val);
}


