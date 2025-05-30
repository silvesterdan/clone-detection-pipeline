public void deleteRecursive (File path) {
    File [] c = path.listFiles ();
    System.out.println ("Cleaning out folder:" + path.toString ());
    for (File file : c) {
        if (file.isDirectory ()) {
            System.out.println ("Deleting file:" + file.toString ());
            deleteRecursive (file);
            file.delete ();
        } else {
            file.delete ();
        }
    }
    path.delete ();
}



public void deleteRecursive (File path) {
    for (File file : path.listFiles ()) {
        if (file.isDirectory ()) {
            deleteRecursive (file);
            System.out.println ("Folder deleted:" + file.toString ());
        }
        file.delete ();
    }
    path.delete ();
    System.out.println ("Folder cleaned:" + path.toString ());
}


