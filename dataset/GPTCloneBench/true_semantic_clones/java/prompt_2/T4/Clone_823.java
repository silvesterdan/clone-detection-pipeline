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
    String high = "", low = value;
    if (value.length() >= getPartDivider()){
        int index = value.length() - getPartDivider();
        high = value.substring(0, index);
        low = value.substring(index);
    }

    StringJoiner sj = new StringJoiner(SEPARATOR);
    sj.add(getHighProcessor().getName(high));
    sj.add(getToken());
    sj.add(getLowProcessor().getName(low));

    return sj.toString();
}


