public static void main (String [] args) {
    Scanner scanner = new Scanner (System.in);
    String line = scanner.nextLine ();
    int trys = Integer.parseInt (line.trim ());
    for (int i = 0;
    i < trys; i ++) {
        double probability = processTry (scanner);
        System.out.println (probability);
    }
    scanner.close ();
}


public static void main (String [] args) {
    Scanner scanner = new Scanner (System.in);
    String line = scanner.nextLine ();
    int trys = Integer.parseInt (line.trim ());
    for (int i = 0;
    i < trys; i ++) {
        double score = calculateScore(scanner);
        System.out.println (score);
    }
    scanner.close ();
}
