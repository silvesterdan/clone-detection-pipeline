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


 public static int[][] getRows(int begin, int fin, int [][] array)
{
    int rows = fin - begin + 1;
    int[][] result = new int[rows][];
    int index = 0;

    while(begin <= fin)
    {
        result[index++] = array[begin++];
    }
    return result;
}


