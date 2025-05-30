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
    ByteArrayOutputStream outputStream = null;
    InputStream inStream = null;
    try {
        outputStream = new ByteArrayOutputStream ();
        inStream = new FileInputStream (file);
        byte [] buffer = new byte [4096];
        int bytesRead;
        while ((bytesRead = inStream.read (buffer)) != - 1) {
            outputStream.write (buffer, 0, bytesRead);
        }
    } finally {
        try {
            if (outputStream != null) outputStream.close ();
        } catch (IOException e) {
        }
        try {
            if (inStream != null) inStream.close ();
        } catch (IOException e) {
        }
    }
    return outputStream.toByteArray ();

}
