public String toString () {
    StringBuilder sb = new StringBuilder ();
    sb.append ("--------" + v + "\n");
    sb.append ("--------" + w + "\n");
    for (B elem : bList) {
        sb.append (elem + "\n");
    }
    return sb.toString ();
}


public String toString () {
    String input = "";
    input += "--------" + v + "\n";
    input += "--------" + w + "\n";
    for (B elem : bList) {
        input += elem + "\n";
    }
    return input;
}


