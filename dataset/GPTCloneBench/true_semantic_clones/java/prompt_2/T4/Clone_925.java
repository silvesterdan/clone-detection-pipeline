public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException {
                File dstFile = new File (strAbsPathDest + file.toAbsolutePath ().toString ().substring (strAbsPathSrc.length ()));
                if (dstFile.exists ()) return FileVisitResult.CONTINUE;
                if (! dstFile.getParentFile ().exists ()) dstFile.getParentFile ().mkdirs ();
                Files.copy (file, dstFile.toPath ());
                return FileVisitResult.CONTINUE;
}


 
public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
	  File dstFile = new File(strAbsPathDest + file.toAbsolutePath().toString().substring(strAbsPathSrc.length()));
	  if(dstFile.exists()) {
	    return FileVisitResult.CONTINUE;
	  } else {
	    try {
	      if(!dstFile.getParentFile().exists()) {
		dstFile.getParentFile().mkdirs();
	      }
	      Files.copy(file, dstFile.toPath());
	    } catch (IOException e) {
	      return FileVisitResult.CONTINUE;
	    }
	    return FileVisitResult.CONTINUE;
	  }
}


