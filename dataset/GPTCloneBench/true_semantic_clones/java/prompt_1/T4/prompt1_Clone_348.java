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
    String result = "";
    if (str.length () >= 2 && str.substring (0, 2).equals ("oz")) {
        result = "oz";
    } else if (str.length () >= 2 && str.substring (1, 2).equals ("z")) {
        result = "z";
    } else if (str.length () >= 2 && str.substring (0, 1).equals ("o")) {
        result = "o";
    }
    return result;
}


