public static void main (String [] args) throws IOException {
    BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
    System.out.print ("Enter String");
    String s = br.readLine ();
    System.out.print ("Enter Integer:");
    try {
        int i = Integer.parseInt (br.readLine ());
    } catch (NumberFormatException nfe) {
        System.err.println ("Invalid Format!");
    }
}


public static void main (String [] args) throws IOException {
    BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
    String strPrompt = "Enter String:";
    String intPrompt = "Enter Integer:";
    String errMsg = "Invalid Format!";
    
    System.out.println (strPrompt);
    String userString = br.readLine ();
    System.out.println (intPrompt);
    try {
        int userInt = Integer.parseInt (br.readLine ());
    } catch (NumberFormatException nfe) {
        System.err.println (errMsg);
    }
}


