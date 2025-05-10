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
    int row = 1;
    while (row <= 7) {
        int space = 7;
        while (space >= row) {
            System.out.print ("*");
            space -= 2;
        }
        int i = 1;
        while (i <= row){
            System.out.print (" ");
            i++;
        }
        System.out.print ("\n");
        row += 2;
    }
    int row2 = 5;
    while (row2 >= 1) {
        int space2 = 7;
        while (space2 >= row2) {
            System.out.print ("*");
            space2 -= 2;
        }
        int i2 = 1;
        while (i2 <= row2){
            System.out.print (" ");
            i2++;
        }
        System.out.print ("\n");
        row2 -= 2;
    }
}


