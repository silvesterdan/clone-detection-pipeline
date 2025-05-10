public String startOz (String str) {
    int len = str.length ();
    if (len < 1) return new String ("");
    if (len > 1 && str.charAt (0) == 'o' && str.charAt (1) == 'z') return new String ("oz");
    if (str.charAt (0) == 'o') return new String ("o");
    if (str.charAt (1) == 'z') return new String ("z");
    return new String ("");
}


public String startOz (String str) {
    int length = str.length();
    if (length < 1) return "";
    if (length == 1) return (str.charAt(0) == 'o') ? "o" : "";
    else return (str.substring(0, 2).equals("oz")) ? "oz" : ((str.charAt(0) == 'o') ? "o" : "" + (str.charAt(1) == 'z') ? "z" : "");
}


