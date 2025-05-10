private void addFolderToZip (String path, String srcFolder, ZipOutputStream zip) throws IOException {
    File folder = new File (srcFolder);
    if (folder.list ().length == 0) {
        addFileToZip (path, srcFolder, zip, true);
    } else {
        for (String fileName : folder.list ()) {
            if (path.equals ("")) {
                addFileToZip (folder.getName (), srcFolder + "/" + fileName, zip, false);
            } else {
                addFileToZip (path + "/" + folder.getName (), srcFolder + "/" + fileName, zip, false);
            }
        }
    }
}





private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws IOException {
    File folder = new File(srcFolder);
    String[] fileList = folder.list();

    if (fileList.length == 0) {
        addFileToZip(path, srcFolder, zip, true);
    } else {
        for (String aFileList : fileList) {
            String filePath = srcFolder + "/" + aFileList;
            addFileToZip((path.equals("") ? folder.getName() : path + "/" + folder.getName()), filePath, zip, false);
        }
    }
}


