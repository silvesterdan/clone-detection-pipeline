public static void main (String [] args) throws InterruptedException {
    while (makeMore) {
        new Leakee (0).check ();
    }
    while (true) {
        Thread.sleep (1000);
        System.out.println ("memory=" + Runtime.getRuntime ().freeMemory () + " / " + Runtime.getRuntime ().totalMemory ());
    }
}


public static void main (String [] args) throws InterruptedException {
    while (makeMore) {
        new Leakee (2).check ();
    }
    while (true) {
        Thread.sleep (1000);
        System.out.println ("processing=" + Runtime.getRuntime ().freeProcessors () + " / " + Runtime.getRuntime ().totalProcessors ());
    }
}
