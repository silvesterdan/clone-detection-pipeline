public static void main (String [] args) {
    Scanner in = new Scanner (System.in);
    int n = in.nextInt ();
    int a [] [] = new int [n] [n];
    for (int a_i = 0;
    a_i < n; a_i ++) {
        for (int a_j = 0;
        a_j < n; a_j ++) {
            a [a_i] [a_j] = in.nextInt ();
        }
    }
    int l_sum = 0;
    for (int i = 0;
    i < n; i ++) {
        l_sum += a [i] [i];
    }
    int r_sum = 0;
    for (int j = 0;
    j < n; j ++) {
        r_sum += a [j] [n - 1 - j];
    }
    int sum = l_sum + r_sum;
    System.out.println (sum);
}


 public static void main (String [] args) {
    Scanner in = new Scanner (System.in);
    int n = in.nextInt ();
    int a [][] = new int [n][n];
    for (int i = 0; i < n; i ++) {
        for (int j = 0; j < n; j ++) {
            a [i][j] = in.nextInt ();
        }
    }
    int l_sum = 0;
    for (int b = 0; b < n; b ++) {
        l_sum += a [b] [b] ;
    }
    int r_sum = 0;
    for (int c = 0; c < n; c ++) {
        r_sum += a [n - 1 - c] [c] ;
    }
    int sum = l_sum + r_sum;
    System.out.println (sum);
}
