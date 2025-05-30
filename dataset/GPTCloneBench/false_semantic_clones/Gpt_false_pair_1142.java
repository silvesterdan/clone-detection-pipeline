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


 public String getName (String value) {
    StringBuilder name = new StringBuilder ();
    String upper, lower;
    if (value.length() < getPartDivider()) {
        upper = "";
        lower = value;
    } else {
        int index = value.length() - getPartDivider();
        upper = value.substring(0, index);
        lower = value.substring(index);
    }
    String highName = getHighProcessor().getName(upper);
    String lowName = getLowProcessor().getName(lower);
    if (highName != "") {
        name.append(highName);
        name.append(SEPARATOR);
        name.append(getToken());
        if (highName != lowName) {
            name.append(SEPARATOR);
        }
    }
    if (lowName != "") {
        name.append(lowName);
    }
    return name.toString();
}
