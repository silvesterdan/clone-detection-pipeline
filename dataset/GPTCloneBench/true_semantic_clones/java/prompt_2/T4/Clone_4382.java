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
    boolean isNegative = false;
    if(value.startsWith("-")) {
        isNegative = true;
        value = value.substring(1);
    }
    String[] parts = value.split("\\.");
    String decimalValue;
    if (parts.length > 1) {
        decimalValue = parts[1];
        value = parts[0];
    } else decimalValue = null;
    String name = processor.getName(value);
    name = "".equals(name) ? ZERO_TOKEN : name;
    if(isNegative) name = MINUS + SEPARATOR + name;
    if(decimalValue != null && !decimalValue.isEmpty()) {
        String zeroDecimalValue = String.join("", Collections.nCopies(decimalValue.length(), "0"));
        name += decimalValue.equals(zeroDecimalValue) ? SEPARATOR + UNION_AND + SEPARATOR + "zero" + SEPARATOR + SCALE.getName(-decimalValue.length())
            : SEPARATOR + UNION_AND + SEPARATOR + processor.getName(decimalValue) + SEPARATOR + SCALE.getName(-decimalValue.length());
    }
    return name;
}


