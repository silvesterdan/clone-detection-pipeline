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
    for (row = 1; row <= 7; row += 2) {
        for (space = 7; space >= row; space -= 2) {
            System.out.print ("*");
        }
        for (i = 1; i <= row; i ++) {
            System.out.print (" ");
        }
        System.out.print ("\n");
    }
    for (row = 5; row >= 1; row -= 2) {
        for (space = 7; space >= row; space -= 2) {
            System.out.print ("*");
        }
        for (i = 1; i <= row; i ++) {
            System.out.print (" ");
        }
        System.out.print ("\n");
    }
}


