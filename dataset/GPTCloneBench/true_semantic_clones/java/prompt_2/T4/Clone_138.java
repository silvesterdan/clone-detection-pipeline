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
        char[] cbuf = new char[(int)input.length()];
        FileReader fr = new FileReader(input);
        fr.read(cbuf);
        for(int i=0;i<cbuf.length;i++){
            if(cbuf[i] == '\n') count++;
        }
        fr.close();
        return ++count;
}


