public String startOz (String str) {
    int len = str.length ();
    if (len < 1) return new String ("");
    if (len > 1 && str.charAt (0) == 'o' && str.charAt (1) == 'z') return new String ("oz");
    if (str.charAt (0) == 'o') return new String ("o");
    if (str.charAt (1) == 'z') return new String ("z");
    return new String ("");
}


public String startOz (String inputString) {
    int length = inputString.length();
   
    if (length < 1) {
        return "";
    }
   
    if (length > 1 && inputString.charAt(0) == 'o' && inputString.charAt(1) == 'z') {
        return "oz";
    }
   
    if (inputString.charAt(0) == 'o') {
        return "o";
    }
   
    if (inputString.charAt(1) == 'z') {
        return "z";
    }
   
    return "";
}


