public static void main (String [] args) {
    String str = "my name is khan";
    String words [] = str.split ("\\s");
    String capitalizedWord = "";
    for (String w : words) {
        String first = w.substring (0, 1);
        String f_after = w.substring (1);
        capitalizedWord += first.toUpperCase () + f_after + " ";
    }
    System.out.println (capitalizedWord);
}


 public static void main(String[] args) {
    String str = "my name is khan";
    String[] words = str.split("\\s");
    StringBuilder capitalizedWord = new StringBuilder();
    for (String w : words) {
        String first = String.valueOf(w.charAt(0)).toUpperCase();
        String f_after = w.substring(1);
        capitalizedWord.append(first).append(f_after).append(" ");
    }
    System.out.println("The capitalized string is : " + capitalizedWord);
}


