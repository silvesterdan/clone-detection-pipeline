public static int countLines (File input) throws IOException {
    try (InputStream is = new FileInputStream (input)) {
        int count = 1;
        for (int aChar = 0;
        aChar != - 1; aChar = is.read ()) count += aChar == '\n' ? 1 : 0;
        return count;
    }
}


public static int countLines (File input) throws IOException {
    InputStream is = new FileInputStream (input);
    int count = 1;
    boolean done = false;
    while(!done) {
        int aChar = is.read();
        if (aChar == - 1) {
            done = true;
        } else {
            count += aChar == '\n' ? 1 : 0;
        }
    }
    is.close();
    return count;
}


