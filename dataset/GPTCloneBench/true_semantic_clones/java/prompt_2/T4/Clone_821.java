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
    if (! highName.isEmpty ()) {
        buffer.append (highName);
        buffer.append (SEPARATOR);
        buffer.append (getToken ());
        if (! lowName.isEmpty ()) {
            buffer.append (SEPARATOR);
        }
    }
    if (! lowName.isEmpty ()) {
        buffer.append (lowName);
    }
    return buffer.toString ();
}


 public String getName(String value){
    String[] parts = value.split(SEPARATOR);
    if (value.length() < getPartDivider()){
        String high = "";
        String low = value;
    } else {
        int index = value.length() - getPartDivider();
        String high = value.substring(0, index);
        String low = value.substring(index);
    }

    String highName = getHighProcessor().getName(high);
    String lowName = getLowProcessor().getName(low);
    String joinedStrings = highName + SEPARATOR + getToken() + SEPARATOR + lowName;

    return joinedStrings;
}


