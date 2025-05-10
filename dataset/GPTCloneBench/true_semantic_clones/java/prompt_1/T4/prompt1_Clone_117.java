public static void main (String [] args) {
    int n = 0;
    Scanner s = new Scanner (System.in);
    System.out.print ("Enter an integer number: ");
    n = s.nextInt ();
    if (n <= 0) System.out.print ("Enter numbers greater than 0");
    else {
        NumberToWord a = new NumberToWord ();
        System.out.print ("After conversion number in words is :");
        a.pw ((n / 1000000000), " Hundred");
        a.pw ((n / 10000000) % 100, " crore");
        a.pw (((n / 100000) % 100), " lakh");
        a.pw (((n / 1000) % 100), " thousand");
        a.pw (((n / 100) % 10), " hundred");
        a.pw ((n % 100), " ");
    }
}


public static void main (String [] args) {
    int n = 0;
    Scanner s = new Scanner (System.in);
    System.out.print ("Enter an integer number: ");
    n = s.nextInt ();
    if (n <= 0) 
        System.out.print ("Enter numbers greater than 0");
    else {
        NumberToWord a = new NumberToWord ();
        System.out.print ("After conversion number in words is :");
        int billion = n / 1000000000;
        a.display(billion, " Hundred");
        int crore = (n / 10000000) % 100;
        a.display(crore, " crore");
        int lakh = ((n / 100000) % 100);
        a.display(lakh, " lakh");
        int thousand = ((n / 1000) % 100);
        a.display(thousand, " thousand");
        int hundred = ((n / 100) % 10);
        a.display(hundred, " hundred");
        int remainder = (n % 100);
        a.display(remainder, " ");
    }
}


