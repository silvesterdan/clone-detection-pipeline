public static boolean isNumber (String str) {
    int i = 0, len = str.length ();
    boolean a = false, b = false, c = false, d = false;
    if (i < len && (str.charAt (i) == '+' || str.charAt (i) == '-')) i ++;
    while (i < len && isDigit (str.charAt (i))) {
        i ++;
        a = true;
    }
    if (i < len && (str.charAt (i) == '.')) i ++;
    while (i < len && isDigit (str.charAt (i))) {
        i ++;
        b = true;
    }
    if (i < len && (str.charAt (i) == 'e' || str.charAt (i) == 'E') && (a || b)) {
        i ++;
        c = true;
    }
    if (i < len && (str.charAt (i) == '+' || str.charAt (i) == '-') && c) i ++;
    while (i < len && isDigit (str.charAt (i))) {
        i ++;
        d = true;
    }
    return i == len && (a || b) && (! c || (c && d));
}


 public static boolean isNumber(String str) {
    int len = str.length();
    int i = 0;
    boolean a = false;
    boolean b = false;
    boolean c = false;
    boolean d = false;

    if(i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
        i++;
    }

    while(i < len && Character.isDigit(str.charAt(i))) {
        a = true;
        i++;
    }

    if(i < len && str.charAt(i) == '.') {
        i++;

        while(i < len && Character.isDigit(str.charAt(i))) {
            b = true;
            i++;
        }
    }

    if(i < len && (str.charAt(i) == 'e' || str.charAt(i) == 'E') && (a || b)) {
        i++;
        c = true;

        if(i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            i++;
        }

        while(i < len && Character.isDigit(str.charAt(i))) {
            d = true;
            i++;
        }
    }

    return i == len && (a || b) && (!c || (c && d));
}


