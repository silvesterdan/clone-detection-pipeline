public void run () {
    System.out.println (i);
    try {
        cb.await ();
        i = i + 3;
        Thread.sleep (1000);
    } catch (InterruptedException e) {
        e.printStackTrace ();
    } catch (BrokenBarrierException e) {
        e.printStackTrace ();
    }
}





public synchronized void run() {
    System.out.println(i);
    try {
        cb.await();
        i = (i + 3) % Integer.MAX_VALUE;
        Thread.sleep(1000);
    } catch (InterruptedException | BrokenBarrierException e) {
        e.printStackTrace();
    }
}


