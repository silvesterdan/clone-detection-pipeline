public String getName (String value) {
    StringBuilder buffer = new StringBuilder ();
    int number;
    if ("".equals (value)) {
        number = 0;
    } else if (value.length () > 4) {
        number = Integer.valueOf (value.substring (value.length () - 4), 10);
    } else {
        number = Integer.valueOf (value, 10);
    }
    number %= 1000;
    if (number >= 100) {
        buffer.append (unitProcessor.getName (number / 100));
        buffer.append (SEPARATOR);
        buffer.append (SCALE.getName (EXPONENT));
    }
    String tensName = tensProcessor.getName (number % 100);
    if (! "".equals (tensName) && (number >= 100)) {
        buffer.append (SEPARATOR);
    }
    buffer.append (tensName);
    return buffer.toString ();
}




public String getName(String value) {
    StringBuilder buffer = new StringBuilder();
    int number = value.trim().isEmpty() ? 0 : Integer.valueOf(value.trim().length() > 4 ? value.trim().substring(value.length() - 4) : value.trim(), 10);
    number %= 1000;
    String tensName = tensProcessor.getName(number % 100);
    return buffer.append((number >= 100) ? unitProcessor.getName(number / 100) + SEPARATOR + SCALE.getName(EXPONENT) + (tensName.isEmpty() ? "" : SEPARATOR) : "").append(tensName).toString();
}


