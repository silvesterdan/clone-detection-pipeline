public static void main (String [] args) {
    Random ran = new Random ();
    int min, max;
    Scanner sc = new Scanner (System.in);
    System.out.println ("Enter min range:");
    min = sc.nextInt ();
    System.out.println ("Enter max range:");
    max = sc.nextInt ();
    int num = ran.nextInt (min);
    int num1 = ran.nextInt (max);
    System.out.println ("Random Number between given range is " + num1);
}


public static void main (String [] args) {
    Scanner sc = new Scanner (System.in);
    System.out.println ("Enter min range:");
    int min = sc.nextInt ();
    System.out.println ("Enter max range:");
    int max = sc.nextInt ();
    double d = Math.random ();
    int result = (int) (min + (d* (max-min)));
    System.out.println ("Random Number between given range is " + result);
}


