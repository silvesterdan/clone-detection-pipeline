public static void main (String [] args) {
    State s = new State ();
    Thread t1 = new Thread (new T1 (s));
    Thread t2 = new Thread (new T2 (s));
    Thread t3 = new Thread (new T3 (s));
    t1.start ();
    t2.start ();
    t3.start ();
}


public static void main (String [] args) {
    State s = new State ();
    ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    threadPool.execute( new T1 (s));
    threadPool.execute( new T2 (s));
    threadPool.execute( new T3 (s));
}


