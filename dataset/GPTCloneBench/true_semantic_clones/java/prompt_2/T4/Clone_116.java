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
	FileReader fr = new FileReader (input);
	while (fr.read () != - 1)
	    if (fr.read () == '\n') count++;
	fr.close ();
	return count + 1;
}


