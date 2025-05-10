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
    String str4 = " starts with lower case"; 
    if (startWithUpperCase (str1)) {
        System.out.println (true);
    } else {
        System.out.println (false); 
    }
    if (startWithUpperCase (str2)) {
        System.out.println (true);
    } else {
        System.out.println (false); 
    }
    if (startWithUpperCase (str3)) {
        System.out.println (true); 
    } else { 
        System.out.println (false);
    }
    if (startWithUpperCase (str4)) {
        System.out.println (true);
    } else {
        System.out.println (false); 
    }
}


