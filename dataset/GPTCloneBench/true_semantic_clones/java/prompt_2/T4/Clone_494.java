        public void run () {
            try {
                printThreads ("Daemon Thread printing");
                Thread.sleep (10000);
            } catch (Exception e) {
            } finally {
                System.out.println ("finally");
            }
}


 public void run () {
            try {
                Thread t = new Thread(() -> {
                    try {
                        printThreads("Daemon Thread printing");
                    } catch (Exception e) {
                    }
                });
                t.start();
                wait(10000); 
            } catch (InterruptedException ie) {
            } finally {
                System.out.println("finally");
            }
}


