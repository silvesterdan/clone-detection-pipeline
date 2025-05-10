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
    String read;
    StringBuilder msg = new StringBuilder ();
    for (;;) {
        read = inputGenerator.getMessage ();
        if (read.toLowerCase ().startsWith ("hi"))
            break;
        else
            msg.append (read); 
    }
    return msg.toString ();
}


