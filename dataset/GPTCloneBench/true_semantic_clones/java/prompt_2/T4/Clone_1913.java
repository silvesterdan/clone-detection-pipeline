public static void countString (String str, char searchKey) {
    String count = "";
    for (int i = 0;
    i < str.length (); i ++) {
        if (str.charAt (i) == searchKey) count += str.charAt (i) + "\n";
    }
    System.out.println (count + "\nNumber of Occurrence of " + searchKey + " is " + count.length () + " in string " + str);
}


 public static void countString(String str, char searchKey){ 
    int count = 0; 
    for (int i = 0; i < str.length(); i++){ 
        if(str.charAt(i)==searchKey){ 
            if(i == 0 || str.charAt(i-1) != searchKey){ 
            count++; 
            } 
        } 
    } 
    System.out.println("Number of Occurrence of " + searchKey + 
                       " is " + count + " in string " + str); 
                                       
} 


