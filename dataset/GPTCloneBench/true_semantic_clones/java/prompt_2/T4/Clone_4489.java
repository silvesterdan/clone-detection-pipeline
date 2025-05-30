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

    if (fileList.length == 0) addFileToZip(path, srcFolder, zip, true);
    else if (path.equals("")) {
        for (String file: fileList) addFileToZip(folder.getName(), srcFolder + File.separator + file, zip, false);
    } else {
        for (String file: fileList) addFileToZip(path + File.separator + folder.getName(), srcFolder + File.separator + file, zip, false);
    }
}


