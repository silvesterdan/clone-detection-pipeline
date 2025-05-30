private static String join (String delimiter, String...parts) {
    StringBuilder builder = new StringBuilder ();
    for (String part : parts) {
        if (! isEmpty (part)) {
            if (builder.length () > 0) {
                builder.append (delimiter);
            }
            builder.append (part);
        }
    }
    return builder.toString ();
}


private static String join (String delimiter, String...parts) {
    String joinedString = "";
    for (String part : parts) {
        if (part != null && part.length() > 0) {
            joinedString += part;
            if (joinedString.length() > 0) {
                joinedString += delimiter;
            }
        }
    }
    return joinedString;
}


