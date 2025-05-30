public byte [] read (File file) throws IOException, FileTooBigException {
    if (file.length () > MAX_FILE_SIZE) {
        throw new FileTooBigException (file);
    }
    ByteArrayOutputStream ous = null;
    InputStream ios = null;
    try {
        byte [] buffer = new byte [4096];
        ous = new ByteArrayOutputStream ();
        ios = new FileInputStream (file);
        int read = 0;
        while ((read = ios.read (buffer)) != - 1) {
            ous.write (buffer, 0, read);
        }
    } finally {
        try {
            if (ous != null) ous.close ();
        } catch (IOException e) {
        }
        try {
            if (ios != null) ios.close ();
        } catch (IOException e) {
        }
    }
    return ous.toByteArray ();
}


 public byte [] read (File file) throws IOException, FileTooBigException {
    if (file.length () > MAX_FILE_SIZE) {
        throw new FileTooBigException (file);
    }
    ByteArrayOutputStream bos = new ByteArrayOutputStream ();
    try (InputStream is = new FileInputStream (file)) {
        byte [] buffer = new byte [4096];
        int read = 0;
        while ((read = is.read (buffer)) != - 1) {
            bos.write (buffer, 0, read);
        }
    }
    return bos.toByteArray ();
}


