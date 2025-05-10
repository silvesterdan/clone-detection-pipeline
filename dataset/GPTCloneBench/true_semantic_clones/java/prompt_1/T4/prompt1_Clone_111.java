public void sort (int [] input) {
    for (int i = 0;
    i < input.length - 1; i ++) {
        int k = i + 1;
        int nxtVal = input [k];
        while (input [k - 1] > nxtVal) {
            input [k] = input [k - 1];
            k --;
            if (k == 0) break;
        }
        input [k] = nxtVal;
    }
    System.out.println ("Medium sorting is done and the result is :");
    for (int i : input) {
        System.out.print (i + ",");
    }
}


public void sort (int [] input) {
    int n;
    for (int i = 0;
    i < input.length - 1; i ++) {
        n = i;
        int nxtVal = input [i + 1];
        while (input [n] > nxtVal && n >= 0) {
            input [n + 1] = input [n];
            n --;
        }
        input [n + 1] = nxtVal;
    }
    System.out.println ("Medium sorting is done and the result is :");
    for (int i : input) {
        System.out.print (i + ",");
    }
}


