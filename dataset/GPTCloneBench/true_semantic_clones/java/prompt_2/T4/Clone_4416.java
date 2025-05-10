public static void main (String [] args) throws InterruptedException {
    AtomicInteger counter = new AtomicInteger ();
    ExecutorService pool = Executors.newFixedThreadPool (4);
    for (int i = 0;
    i < 4; ++ i) {
        pool.execute (new MyTask (counter));
    }
    pool.shutdown ();
    pool.awaitTermination (1, TimeUnit.HOURS);
}






public static void main(String[] args) {
    AtomicInteger counter = new AtomicInteger();
    ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    for (int i = 0; i < 3; i++) {
        pool.execute(new MyTask(counter));
    }
    pool.shutdown();
}


