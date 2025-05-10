public String getName (String value) {
    boolean negative = false;
    if (value.startsWith ("-")) {
        negative = true;
        value = value.substring (1);
    }
    int decimals = value.indexOf (".");
    String decimalValue = null;
    if (0 <= decimals) {
        decimalValue = value.substring (decimals + 1);
        value = value.substring (0, decimals);
    }
    String name = processor.getName (value);
    if ("".equals (name)) {
        name = ZERO_TOKEN;
    } else if (negative) {
        name = MINUS.concat (SEPARATOR).concat (name);
    }
    if (! (null == decimalValue || "".equals (decimalValue))) {
        String zeroDecimalValue = "";
        for (int i = 0;
        i < decimalValue.length (); i ++) {
            zeroDecimalValue = zeroDecimalValue + "0";
        }
        if (decimalValue.equals (zeroDecimalValue)) {
            name = name.concat (SEPARATOR).concat (UNION_AND).concat (SEPARATOR).concat ("zero").concat (SEPARATOR).concat (SCALE.getName (- decimalValue.length ()));
        } else {
            name = name.concat (SEPARATOR).concat (UNION_AND).concat (SEPARATOR).concat (processor.getName (decimalValue)).concat (SEPARATOR).concat (SCALE.getName (- decimalValue.length ()));
        }
    }
    return name;
}


 public String getName(String value) {
    boolean negative = false;
    if (value.startsWith("-")) {
        negative = true;
        value = value.substring(1);
    }
    int decimals = value.indexOf(".");
    String decimalValue = null;
    if (0 <= decimals) {
        decimalValue = value.substring(decimals + 1);
        value = value.substring(0, decimals);
    }
    String name;
    if (negative) {
        name = "Minus" + SEPARATOR;
    }
    else {
        name = "";
    }
    if (decimalValue != null && !decimalValue.equals("")) {
        int numOfZeros = 0;
        for (int i = 0; i < decimalValue.length(); i++) {
            if (decimalValue.charAt(i) == '0') {
                numOfZeros++;
            }
        }
        if (numOfZeros == decimalValue.length()) {
            name = name.concat("Zero").concat(SEPARATOR).concat(SCALE.getName(-decimalValue.length()));
        } else {
            name = name.concat(processor.getName(decimalValue)).concat(SEPARATOR).concat(SCALE.getName(-decimalValue.length()));
        }
    }
    if (name.equals("")) {
        name = processor.getName(value);
        if (name.equals("")) {
            name = ZERO_TOKEN;
        }
    }
    return name;
}


