public static void main (String [] args) {
    int sayThisManyTimes = 5;
    AtomicBoolean saidHello = new AtomicBoolean (false);
    MyThread mt = new MyThread (sayThisManyTimes, saidHello);
    mt.start ();
    for (int i = 0;
    i < sayThisManyTimes; i ++) {
        while (saidHello.get ()) {
        }
        System.out.println ("Hello ");
        saidHello.set (true);
    }
}


 public static void main (String [] args) {
    int sayThisManyTimes = 5;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    MyThread mt = new MyThread (sayThisManyTimes, lock);
    mt.start ();
    for (int i = 0;
    i < sayThisManyTimes; i ++) {
        while (lock.isWriteLocked()) {
        }
        System.out.println ("Hello ");
        lock.writeLock().lock();
    }
}
