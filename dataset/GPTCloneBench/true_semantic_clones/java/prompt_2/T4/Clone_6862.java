public static void main (String [] args) {
    BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
    System.out.print ("Please enter user name : ");
    String username = null;
    try {
        username = reader.readLine ();
    } catch (IOException e) {
        e.printStackTrace ();
    }
    System.out.println ("You entered : " + username);
    Scanner in = new Scanner (System.in);
    System.out.print ("Please enter user name : ");
    username = in.nextLine ();
    System.out.println ("You entered : " + username);
    Console console = System.console ();
    username = console.readLine ("Please enter user name : ");
    System.out.println ("You entered : " + username);
}





public static void main (String [] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    System.out.println("Please enter your name: ");
    String name = br.readLine();
    System.out.println("You entered: "+ name);
}


