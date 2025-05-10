public synchronized void run () {
    int i = 3;
    while (i < 50) {
        while (s.getState () != 2) {
            synchronized (s) {
                try {
                    s.wait ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        }
        synchronized (s) {
            if (s.getState () == 2) System.out.println ("t3 " + i);
            i = i + 3;
            s.setState (3);
            s.notifyAll ();
        }
    }
}


public void run() {
    int i = 3;
    while (i < 50) {
        while (getState(s) != 2) {
            synchronized (s) {
                try {
                    wait(s);
                } catch (InterruptedException e) {
                    printStackTrace(e);
                }
            }
        }
        synchronized (s) {
            if (getState(s) == 2) println("t3 " + i);
            i = i + 3;
            setState(s, 3);
            notifyAll(s);
        }
    }
}


