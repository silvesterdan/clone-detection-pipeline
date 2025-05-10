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
    StringBuilder sb = new StringBuilder ();
    sb.append (v + "\n");
    sb.append (w + "\n");
    Iterator<B> it = bList.iterator ();
    while (it.hasNext ()) {
        sb.append (it.next () + "\n");
    }
    return sb.toString ();
}


