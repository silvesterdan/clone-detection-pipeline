public String getName (String value) {
    StringBuilder buffer = new StringBuilder ();
    String high, low;
    if (value.length () < getPartDivider ()) {
        high = "";
        low = value;
    } else {
        int index = value.length () - getPartDivider ();
        high = value.substring (0, index);
        low = value.substring (index);
    }
    String highName = getHighProcessor ().getName (high);
    String lowName = getLowProcessor ().getName (low);
    if (! "".equals (highName)) {
        buffer.append (highName);
        buffer.append (SEPARATOR);
        buffer.append (getToken ());
        if (! "".equals (lowName)) {
            buffer.append (SEPARATOR);
        }
    }
    if (! "".equals (lowName)) {
        buffer.append (lowName);
    }
    return buffer.toString ();
}


 

public String getName(String value){
    String high = value.length() < getPartDivider() ? "" : value.substring (0, value.length() - getPartDivider());
    String low = value.substring(value.length() - getPartDivider());
    String highName = getHighProcessor().getName (high);
    String lowName = getLowProcessor().getName (low);
    return (!"".equals(highName) ? highName + SEPARATOR + getToken() + (!"".equals(lowName) ? SEPARATOR : "") : "") + (!"".equals(lowName) ? lowName : "");
}


