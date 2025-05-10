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


private String capitalize (String s) {
    char first = s == null || s.length () == 0 ? 
                Character.UNASSIGNED : s.charAt (0);
    return Character.isUpperCase (first) ? s : 
            Character.toUpperCase (first) + s.substring (1);
}


