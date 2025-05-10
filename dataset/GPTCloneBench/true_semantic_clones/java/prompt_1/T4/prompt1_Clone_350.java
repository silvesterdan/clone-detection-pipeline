public String startOz (String str) {
    int len = str.length ();
    if (len < 1) return new String ("");
    if (len > 1 && str.charAt (0) == 'o' && str.charAt (1) == 'z') return new String ("oz");
    if (str.charAt (0) == 'o') return new String ("o");
    if (str.charAt (1) == 'z') return new String ("z");
    return new String ("");
}


public String startOz(String s) {
    int len = s.length();

    if (len < 1) {
        return "";
    }

    if (len > 1 && s.charAt(0) == 'o' && s.charAt(1) == 'z') {
        return "oz";
    }

    String r = "";
    if (s.charAt(0) == 'o') {
        r = r.concat("o");
    }
    if (s.charAt(1) == 'z') {
        r = r.concat("z");
    }
    return r;
}


