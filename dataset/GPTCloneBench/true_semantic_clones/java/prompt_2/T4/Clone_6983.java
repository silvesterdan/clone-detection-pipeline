public static void main (String h []) {
    Scanner sc = new Scanner (System.in);
    int decimal = sc.nextInt ();
    String binary = "";
    if (decimal <= 0) {
        System.out.println ("Please Enter more than 0");
    } else {
        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal = decimal / 2;
        }
        System.out.println ("binary is:" + binary);
    }
}



 

public static void main (String h []) {
    java.util.stream.Stream.generate(new java.util.Scanner(System.in)::nextInt).filter(n -> n > 0).forEach(
        decimal -> {
            String binary = Integer.toBinaryString(decimal);
            System.out.println ("binary is:" + binary);
        }
    );
}


