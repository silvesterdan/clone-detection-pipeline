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
    int size = bList.size ();
    input += "--------" + v + "\n";
    input += "--------" + w + "\n";
    for (int i = 0; i < size; i++) {
        B elem = bList.get (i);
        input += elem + "\n";
    }
    return input;    
}


