public static boolean deleteDirectory (File directory) {
    if (directory.exists ()) {
        File [] files = directory.listFiles ();
        if (null != files) {
            for (int i = 0;
            i < files.length; i ++) {
                if (files [i].isDirectory ()) {
                    deleteDirectory (files [i]);
                } else {
                    files [i].delete ();
                }
            }
        }
    }
    return (directory.delete ());
}


 public static boolean disposeDirectory (File directory) {
    if (directory.exists ()) {
        File [] files = directory.listFiles ();
        if (null != files) {
            for (int a = 0; 
            a < files.length; a ++) {
                if (files [a].isDirectory ()) {
                    disposeDirectory (files [a]);
                } else {
                    files [a].delete ();
                }
            }
        }
    }
    return (directory.delete ());
}
