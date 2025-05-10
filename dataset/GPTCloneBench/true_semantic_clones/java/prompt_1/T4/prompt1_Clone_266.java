public String toString () {
    StringBuilder sb = new StringBuilder ();
    sb.append (a + "\n");
    sb.append (b + "\n");
    for (A elem : aList) {
        sb.append (elem + "\n");
    }
    return sb.toString ();
}


public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(a);
    sb.append("\n");
    sb.append(b);
    sb.append("\n");
    aList.forEach(elem -> sb.append(elem).append("\n"));
    return sb.toString().trim();
}


