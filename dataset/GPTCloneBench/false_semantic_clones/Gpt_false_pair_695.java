static void shuffleArray (int [] ar) {
    Random rnd = ThreadLocalRandom.current ();
    for (int i = ar.length - 1;
    i > 0; i --) {
        int index = rnd.nextInt (i + 1);
        int a = ar [index];
        ar [index] = ar [i];
        ar [i] = a;
    }
}


 static void shuffleArray (int [] ar) {
    SecureRandom sr = new SecureRandom();
    for (int i = ar.length-1; i > 0; i--) {
        int index = sr.nextInt(i+1);
        int temp = ar[index];
        ar[index] = ar[i];
        ar[i] = temp;
    }
}
