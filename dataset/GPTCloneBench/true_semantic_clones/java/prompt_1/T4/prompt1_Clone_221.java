public static void main (String [] args) {
    for (int row = 1;
    row <= 7; row += 2) {
        for (int space = 7;
        space >= row; space -= 2) {
            System.out.print ("*");
        }
        for (int i = 1;
        i <= row; i ++) {
            System.out.print (" ");
        }
        System.out.print ("\n");
    }
    for (int row = 5;
    row >= 1; row -= 2) {
        for (int space = 7;
        space >= row; space -= 2) {
            System.out.print ("*");
        }
        for (int i = 1;
        i <= row; i ++) {
            System.out.print (" ");
        }
        System.out.print ("\n");
    }
}


public static void main (String [] args) {
    int row, space, i;
    row = 1;
    while (row <= 7) {
        space = 7;
        while (space >= row) {
            System.out.print ("*");
            space = space - 2;
        }
        i = 1;
        while (i <= row) {
            System.out.print (" ");
            i = i + 1;
        }
        System.out.print ("\n");
        row = row + 2;
    }
    row = 5;
    while (row >= 1) {
        space = 7;
        while (space >= row) {
            System.out.print ("*");
            space = space - 2;
        }
        i = 1;
        while (i <= row) {
            System.out.print (" ");
            i = i + 1;
        }
        System.out.print ("\n");
        row = row - 2;
    }
}


