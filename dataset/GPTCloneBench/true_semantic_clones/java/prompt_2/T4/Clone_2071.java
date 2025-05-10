public static double [] [] amountOTP (double [] [] a, int x) {
    double [] [] b = new double [x] [x];
    x = Math.min (x, a.length);
    for (int i = 0;
    i < x; i ++) for (int j = 0;
    j < x; j ++) b [i] [j] = a [i] [j];
    return b;
}


 public static double[][] amountOTP (double[][] a, int x)
{
    // Create a new double array
    double[][] b = new double[x][x];

    // Use Math.min() to set x correctly
    x = Math.min (x, a.length);

    // Create a for loop to go through each element in array a
    int i;
    int j;
    for (i = 0; i < x; i++)
    {
        for (j = 0; j < x; j++) 
        {
            // Assign values from a to b
            b[i][j] = a[i][j];
        }
    }

    // Return filled double array
    return b;
}


