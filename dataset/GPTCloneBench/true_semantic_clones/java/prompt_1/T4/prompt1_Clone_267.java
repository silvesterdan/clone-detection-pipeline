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
    List<String> list = new ArrayList<String>();
    list.add(a);
    list.add(b);
    for (A elem : aList) {
        list.add(elem.toString());
    }
    return list.stream().collect(Collectors.joining("\n"));
}


