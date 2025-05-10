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


public static String startOz (String str) {
    StringBuilder result = new StringBuilder();
    if (str.length () >=2 && str.contains("oz")) {
        result.append("oz");
    }
    if (str.length () >=2 && str.contains("z") && str.indexOf("z") == 1) {
        result.append("z");
    }
    if (str.length () >=2 && str.contains("o") && str.indexOf("o") == 0) {
        result.append("o");
    }
    return result.toString();
}


