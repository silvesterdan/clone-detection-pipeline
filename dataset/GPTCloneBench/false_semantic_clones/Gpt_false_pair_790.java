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
    ReentrantLock lock = new ReentrantLock();
    MyThread mt = new MyThread (sayThisManyTimes, lock);
    mt.start ();
    for (int i = 0;
    i < sayThisManyTimes; i ++) {
        while (lock.isLocked()) {
        }
        System.out.println ("Hello ");
        lock.lock();
    }
}
