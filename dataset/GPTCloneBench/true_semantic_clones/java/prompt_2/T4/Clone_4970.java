public static void main (String [] args) {
    Scanner sc = new Scanner (System.in);
    int cases = sc.nextInt ();
    String [] str = new String [cases];
    for (int i = 0;
    i < cases; i ++) {
        str [i] = sc.next ();
    }
}



 

public static void main (String [] args) throws IOException {
    FileReader reader = new FileReader("input.txt");
    BufferedReader br = new BufferedReader(reader);
    int cases = Integer.parseInt(br.readLine());
    String[] str = new String[cases];
    for (int i = 0; i < cases; i++)
        str[i] = br.readLine();
}  


 

public static void main (String [] args) throws IOException {
    DataInputStream dataInputStream = new DataInputStream(System.in);
    int cases = dataInputStream.readInt();
    String [] str = new String[cases];
    for (int i = 0; i < cases; i ++) {
        str[i] = dataInputStream.readLine();
    }
}


