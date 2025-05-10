public String getString () {
    StringBuilder msg = new StringBuilder ();
    String read;
    do {
        read = inputGenerator.getMessage ();
        msg.append (read);
    } while (read.toLowerCase ().startsWith ("hi"));
    return msg.toString ();
}


public String getString () {
    StringBuilder msg = new StringBuilder ();
    String read;
    int a = 0;
    while (true) {
        read = inputGenerator.getMessage ();
        if (a != 0 && read.toLowerCase ().startsWith ("hi"))
            break;
        else
            msg.append (read);
        a++;
    }
    return msg.toString ();
}


