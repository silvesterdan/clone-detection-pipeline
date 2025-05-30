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





public String getName (String value) {
            String high, low;
            if (value.length () < getPartDivider ()) {
                high = "";
                low = value;
            } else {
                high = value.substring (0, value.length () - getPartDivider ());
                low = value.substring (value.length () - getPartDivider ());
            }
            return processNames(high, low);
        }

        private String processNames(String high, String low) {
            StringBuilder buffer = new StringBuilder ();
            String highName = getHighProcessor ().getName (high);
            if (! highName.isEmpty ()) buffer.append (highName).append (SEPARATOR).append (getToken ());
            String lowName = getLowProcessor ().getName (low);
            if (!lowName.isEmpty()) {
                if (buffer.length() > 0) buffer.append (SEPARATOR);
                buffer.append(lowName);
            }
            return buffer.toString ();
}


