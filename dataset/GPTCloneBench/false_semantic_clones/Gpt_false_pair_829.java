public void run () {
    for (int i = 0;
    i <= 10; i += 2) {
        synchronized (o) {
            try {
                while (turn) {
                    o.wait ();
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace ();
            } finally {
                System.out.println (i);
                turn = ! turn;
                o.notifyAll ();
            }
        }
    }
}


 public void run() {
    Object lockObject = new Object();
    for (int i = 0; i <= 10; i+=2) {
        synchronized (lockObject) {
            try {
                while (turn) {
                    lockObject.wait();
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                System.out.println(i);
                turn = true;
                lockObject.notifyAll();
            }
        }
    }
}
