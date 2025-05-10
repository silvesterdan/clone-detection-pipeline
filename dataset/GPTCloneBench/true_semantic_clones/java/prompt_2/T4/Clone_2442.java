public static File createTempDir () {
    File baseDir = new File (System.getProperty ("java.io.tmpdir"));
    String baseName = System.currentTimeMillis () + "-";
    for (int counter = 0;
    counter < TEMP_DIR_ATTEMPTS; counter ++) {
        File tempDir = new File (baseDir, baseName + counter);
        if (tempDir.mkdir ()) {
            return tempDir;
        }
    }
    throw new IllegalStateException ("Failed to create directory within " + TEMP_DIR_ATTEMPTS + " attempts (tried " + baseName + "0 to " + baseName + (TEMP_DIR_ATTEMPTS - 1) + ')');
}




public static File createTempDir() {
    String baseDirPath = System.getProperty("java.io.tmpdir");
    Random random = new Random();
    File tempDir;
    do {
        tempDir = new File(baseDirPath, RandomStringUtils.randomAlphabetic(10));
    } while(tempDir.exists());
    tempDir.mkdir();
    return tempDir;
}


