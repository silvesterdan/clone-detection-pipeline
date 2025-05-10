private static String merge (String...strings) {
    StringBuilder sb = new StringBuilder ();
    int adv;
    boolean edited;
    adv = 0;
    edited = true;
    while (edited) {
        edited = false;
        for (String s : strings) {
            if (adv < s.length ()) {
                sb.append (s.charAt (adv));
                edited = true;
            }
        }
        adv ++;
    }
    return sb.toString ();
}


private static String merge (String[] strings) {
    StringBuilder sb = new StringBuilder ();
    int index;
    for (index = 0; index < strings[0].length(); index++) {
        for (int j = 0; j < strings.length; j++) {
            if (index < strings[j].length()) {
                sb.append(strings[j].charAt(index));
            }
        }
    }
    return sb.toString ();
}


