static void permute (int level, String prefix) {
    if (level == 0) {
        System.out.println (prefix);
        return;
    }
    for (int i = 0;
    i < s.length (); i ++) permute (level - 1, prefix + s.charAt (i));
}





static void permute (int depth, String prefix) {
    if (depth == 0) {
      System.out.println (prefix);
    } else {
      int len = s.length ();
      for (int i = 0; i < len; i++) {
        permute (depth - 1, prefix + s.charAt (i));
      }
    }
}


