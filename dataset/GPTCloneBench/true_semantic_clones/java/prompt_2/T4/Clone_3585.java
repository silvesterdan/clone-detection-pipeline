public void run () {
    for (int i = 0;
    ; i ++) {
        if (i % 1000 == 0) {
            System.out.printf ("get: %d\n", i);
        }
        Map < K, String > m2 = new HashMap < > (map);
    }
}




public void run () {
    int i = 0;
    do {
        if (i % 1000 == 0) {
            System.out.printf ("get: %s\n", i);
        }
        Map < K, String > m2 = new ConcurrentHashMap < > (map);
        i++;
    }while(true);
}


