public static void main (String...args) throws Exception {
    List < char [] > myArray = new ArrayList < char [] > ();
    myArray.add ("string1".toCharArray ());
    myArray.add ("string2".toCharArray ());
    myArray.add ("string3".toCharArray ());
    char [] [] charArray2D = myArray.toArray (new char [0] [0]);
    System.out.println (charArray2D.length);
    StringBuilder s = new StringBuilder ();
    for (char [] c : myArray) {
        s.append (String.copyValueOf (c));
    }
    char [] charArray1D = s.toString ().toCharArray ();
    System.out.println (charArray1D.length);
}


 public static void main(String... args) throws Exception {
    List<char[]> myArray = new ArrayList<char[]>();
    myArray.add("string1".toCharArray());
    myArray.add("string2".toCharArray());
    myArray.add("string3".toCharArray());
    char[][] charArray2D = Arrays.stream(myArray).map(char[]::clone).toArray(char[][]::new); 
    System.out.println(charArray2D.length);
    StringBuilder s = new StringBuilder();
    for (char[] c : myArray) {
        s.append(String.copyValueOf(c));
    }
    char[] charArray1D = s.toString().toCharArray();
    System.out.println(charArray1D.length);
}
