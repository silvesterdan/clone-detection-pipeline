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
    return String.join("\n", Stream.concat(Stream.of(a, b), aList.stream().map(Object::toString)).collect(Collectors.toList()));
}


