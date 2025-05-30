public int solution (int X, int [] A) {
    int len = A.length;
    if (X > len) {
        return - 1;
    }
    int [] isFilled = new int [X];
    int jumped = 0;
    Arrays.fill (isFilled, 0);
    for (int i = 0;
    i < len; i ++) {
        int x = A [i];
        if (x <= X) {
            if (isFilled [x - 1] == 0) {
                isFilled [x - 1] = 1;
                jumped += 1;
                if (jumped == X) {
                    return i;
                }
            }
        }
    }
    return - 1;
}


   
 

public int solution (int X, int[] A) {
    int len = A.length;
    int[] visited = new int[X+1];
    java.util.Arrays.fill(visited, -1);  
    int count = X;
    for (int i = 0; i < len; i++) {
        if (visited[A[i]] == -1) {
            count--;
            visited[A[i]] = 1;
            if (count == 0)
                return i;
        }
    }
    return -1;
}


