public static String startOz (String str) {
    if (str.length () >= 2 && str.substring (0, 2).equals ("oz")) {
        return "oz";
    } else if (str.length () >= 2 && str.substring (1, 2).equals ("z")) {
        return "z";
    } else if (str.length () >= 2 && str.substring (0, 1).equals ("o")) {
        return "o";
    }
    return "";
}


  public static String startOz(String str) { 
      if (str.length() >= 1 && str.charAt(0) == 'o') { 
          if (str.length() >= 2 && str.charAt(1) == 'z') 
             return "oz"; 
          return "o"; 
      }else if (str.length() >= 2 && str.charAt(1) == 'z') 
          return "z"; 
      return ""; 
}


