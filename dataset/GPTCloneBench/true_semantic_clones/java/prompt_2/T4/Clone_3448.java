char wf () {
    Scanner input = new Scanner (System.in);
    System.out.println ("What is your choice? (x/o)");
    if (input.findInLine (".") != null) {
        choice = input.findInLine (".").charAt (0);
        while (choice != 'x' && choice != 'o') {
            System.out.println ("You must enter x or o!");
            choice = input.findInLine (".").charAt (0);
        }
    }
    return choice;
}




char wf () {
    char c;
    while (true) {
        System.out.println("What is your choice? (x/o)");
        c = new java.util.Scanner(System.in).next().charAt(0);
        if (c == 'x' || c == 'o') break;
    }
    return c;
}


