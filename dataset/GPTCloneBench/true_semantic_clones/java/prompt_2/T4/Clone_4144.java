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
    int number = Optional.ofNullable(value)
                         .filter(v -> !v.isEmpty())
                         .map(v -> v.length() > 4 ? v.substring(v.length() - 4) : v)
                         .map(Integer::parseInt)
                         .orElse(0);
    
    String tensName = tensProcessor.getName(number % 100);
    String unitName = number >= 100 
                      ? unitProcessor.getName(number / 100) + SEPARATOR + SCALE.getName(EXPONENT) 
                      : "";
    
    return Stream.of(unitName, tensName)
                 .filter(s -> !s.isEmpty())
                 .collect(Collectors.joining(SEPARATOR));
}


