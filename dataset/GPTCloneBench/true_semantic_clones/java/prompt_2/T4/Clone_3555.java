public static void main (String [] args) {
    byte [] dataToCompress = "This is the test data.".getBytes (StandardCharsets.ISO_8859_1);
    try {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream (dataToCompress.length);
        try {
            GZIPOutputStream zipStream = new GZIPOutputStream (byteStream);
            try {
                zipStream.write (dataToCompress);
            } finally {
                zipStream.close ();
            }
        } finally {
            byteStream.close ();
        }
        byte [] compressedData = byteStream.toByteArray ();
        FileOutputStream fileStream = new FileOutputStream ("C:/Users/UserName/Desktop/zip_file.gz");
        try {
            fileStream.write (compressedData);
        } finally {
            try {
                fileStream.close ();
            } catch (Exception e) {
            }
        }
    } catch (Exception e) {
        e.printStackTrace ();
    }
}





public static void main(String[] args) {
    byte[] dataToCompress = "This is the test data.".getBytes(StandardCharsets.ISO_8859_1);
    File file = new File("zip_file.gz");
    try ( FileOutputStream fileStream = new FileOutputStream(file);
          ByteArrayOutputStream byteStream = new ByteArrayOutputStream (dataToCompress.length);
          GZIPOutputStream zipStream = new GZIPOutputStream (byteStream)) {
            zipStream.write (dataToCompress);
            byte [] compressedData = byteStream.toByteArray ();
            fileStream.write (compressedData);
    } catch (Exception e) {
        e.printStackTrace ();
    }
}


