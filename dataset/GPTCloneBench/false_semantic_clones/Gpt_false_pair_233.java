public void run () {
    String threadName = Thread.currentThread ().getName ();
    try {
        first.lock ();
        latch.countDown ();
        System.out.println (threadName + ": locked first lock");
        latch.await ();
        System.out.println (threadName + ": attempting to lock second lock");
        second.lock ();
        System.out.println (threadName + ": never reached");
    } catch (InterruptedException e) {
        throw new RuntimeException (e);
    }
}


  public void run () {
    String threadName = Thread.currentThread ().getName ();
    try {
        while (true) {
            if (first.tryLock()) {
                synchronized (second) {
                    latch.countDown ();
                    System.out.println (threadName + ": locked first lock");
                    latch.await ();
                    System.out.println (threadName + ": attempting to lock second lock");
                    second.lock ();
                    System.out.println (threadName + ": never reached");
                }
            }
        }
    } catch (InterruptedException e) {
        throw new RuntimeException (e);
    }
}
