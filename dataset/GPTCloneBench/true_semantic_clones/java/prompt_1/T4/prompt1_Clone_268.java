public String toString () {
    StringBuilder sb = new StringBuilder ();
    sb.append (a + "\n");
    sb.append (b + "\n");
    for (A elem : aList) {
        sb.append (elem + "\n");
    }
    return sb.toString ();
}


public String toString () {
    String sb = "";
    sb += (a + "\n");
    sb += (b + "\n");
    for (A elem : aList) {
        sb += (elem + "\n");
    }
    return sb;
}


