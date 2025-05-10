public static int [] [] getRows (int i, int j, int [] [] array) {
    int [] [] another = new int [j - i + 1] [];
    while (i <= j) {
        for (int k = 0;
        k < another.length; k ++) {
            another [k] = array [i];
            i ++;
        }
    }
    return another;
}


 public static int[][] getRows(int start, int end, int[][] array)
{
    int rows = end - start + 1;
    int[][] result = new int[rows][];
    int j = 0;
    
    for(int i = start; i <= end; i++) 
    {
        result[j++] = array[i];
    }
    return result;
}


