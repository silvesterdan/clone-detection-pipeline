private String capitalize (String s) {
    if (s == null || s.length () == 0) {
        return "";
    }
    char first = s.charAt (0);
    if (Character.isUpperCase (first)) {
        return s;
    } else {
        return Character.toUpperCase (first) + s.substring (1);
    }
}


  private String capitalize(String s) {
	  if (s == null || s.length() == 0) {
	    return "";
	  }

	  if (Character.isUpperCase(s.charAt(0))) {
	    return s;
	  }

	  char[] chars = s.toCharArray();
	  chars[0] = Character.toUpperCase(chars[0]);

	  String modifiedString = String.copyValueOf(chars);
	  return modifiedString;
}


