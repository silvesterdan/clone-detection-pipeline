public void run () {
    try {
        for (int i = 0;
        i < 2; i ++) {
            System.out.println ("tic");
        }
    } catch (Exception e) {
        e.getStackTrace ();
    }
}


 public void run() {
    int counter = 0;
    do {
        System.out.println("tic");
        counter++;
    } while (counter < 2);
}


