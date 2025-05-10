public void run () {
    Object o = object;
    for (;;) {
        try {
            sleep (Long.MAX_VALUE);
        } catch (InterruptedException e) {
        }
    }
}


public void run () {
    while (true) {
        try {
            Thread.sleep (Long.MAX_VALUE);
        } catch (InterruptedException e) {
        }
    }
}


