public String startOz (String str) {
    int len = str.length ();
    if (len < 1) return new String ("");
    if (len > 1 && str.charAt (0) == 'o' && str.charAt (1) == 'z') return new String ("oz");
    if (str.charAt (0) == 'o') return new String ("o");
    if (str.charAt (1) == 'z') return new String ("z");
    return new String ("");
}


 public String startOz(String str) {
    if (str == null || str.isEmpty()) {
        return "";
    }
    StringBuilder sb = new StringBuilder();

    if (str.charAt(0) == 'o') {
        sb.append("o");
    }

    if (str.length() > 1 && str.charAt(1) == 'z') {
        sb.append("z");
    }
    return sb.toString();
}


