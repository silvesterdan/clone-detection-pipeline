public static void main (String [] args) {
    String str1 = "";
    String str2 = null;
    String str3 = "Starts with upper case";
    String str4 = "starts with lower case";
    System.out.println (startWithUpperCase (str1));
    System.out.println (startWithUpperCase (str2));
    System.out.println (startWithUpperCase (str3));
    System.out.println (startWithUpperCase (str4));
}


public static void main (String [] args) {
    String str1 = "";
    String str2 = null;
    String str3 = "Starts with upper case";
    String str4 = "starts with lower case";
    boolean isUpperCase1 = startWithUpperCase (str1);
    boolean isUpperCase2 = startWithUpperCase (str2); 
    boolean isUpperCase3 = startWithUpperCase (str3);
    boolean isUpperCase4 = startWithUpperCase (str4);
    System.out.println (isUpperCase1);
    System.out.println (isUpperCase2);
    System.out.println (isUpperCase3);
    System.out.println (isUpperCase4);
}


