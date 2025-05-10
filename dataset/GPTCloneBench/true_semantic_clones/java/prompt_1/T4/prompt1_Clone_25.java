public static int countLines (File input) throws IOException {
    try (InputStream is = new FileInputStream (input)) {
        int count = 1;
        for (int aChar = 0;
        aChar != - 1; aChar = is.read ()) count += aChar == '\n' ? 1 : 0;
        return count;
    }
}


public static int countLines (File input) throws IOException {
    int count = 0;
    try (InputStream is = new FileInputStream (input)) {
        input.open();
        while (true) {
            int aChar = is.read();
            if (aChar == -1) {
                break;
            }
            count += aChar == '\n' ? 1 : 0; 
        }
    }
    return count;
}


