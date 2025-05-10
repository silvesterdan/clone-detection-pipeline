public static void main (String [] args) throws InterruptedException {
    BlockingQueue < Object > expensiveObjects = new LinkedBlockingQueue < > ();
    expensiveObjects.put (new Object ());
    expensiveObjects.put (new Object ());
    expensiveObjects.put (new Object ());
    expensiveObjects.put (new Object ());
    ExecutorService executorService = Executors.newFixedThreadPool (4);
    for (int i = 0;
    i < 4; i ++) {
        executorService.execute (new MyRunnable (expensiveObjects));
    }
    executorService.shutdown ();
    executorService.awaitTermination (5, TimeUnit.SECONDS);
    System.out.println ("Final: " + outputCount.get ());
}


public static void main(String[] args) throws InterruptedException {
    BlockingQueue<Object> expensiveObjects = new LinkedBlockingQueue<>();
    expensiveObjects.put(new Object());
    expensiveObjects.put(new Object());
    expensiveObjects.put(new Object());
    expensiveObjects.put(new Object());
    Thread t1 = new Thread(new MyRunnable(expensiveObjects));
    Thread t2 = new Thread(new MyRunnable(expensiveObjects));
    Thread t3 = new Thread(new MyRunnable(expensiveObjects));
    Thread t4 = new Thread(new MyRunnable(expensiveObjects));
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t1.join();
    t2.join();
    t3.join();
    t4.join();
    System.out.println("Final: " + outputCount.get());
}


