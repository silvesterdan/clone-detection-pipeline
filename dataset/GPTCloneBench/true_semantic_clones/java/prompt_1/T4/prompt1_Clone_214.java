public static void printTable (String [] countries, int [] populations) {
    if (countries.length == 0 || populations.length == 0 || countries.length != populations.length) {
        return;
    }
    int longestCountry = Arrays.stream (countries).map (String :: toString).mapToInt (String :: length).max ().getAsInt ();
    int longestPop = Arrays.stream (populations).mapToObj (Integer :: toString).mapToInt (String :: length).max ().getAsInt ();
    for (int i = 0;
    i < countries.length; i ++) {
        System.out.printf ("%-" + longestCountry + "s | %" + longestPop + "d%n", countries [i], populations [i]);
    }
}


public static void printTable (String [] countries, int [] populations) {
    if (countries.length == 0 || populations.length == 0 || countries.length != populations.length) {
        return;
    }
    int maxCountryLength = 0;
    for (String c : countries) {
        maxCountryLength = maxCountryLength < c.length() ? c.length() : maxCountryLength;
    }
    int maxPopLength = 0;
    for (int p : populations) {
        maxPopLength = maxPopLength < p ? Integer.toString(p).length() : maxPopLength;
    } 
    for (int i = 0;
    i < countries.length; i ++) {
        System.out.printf ("%-" + maxCountryLength + "s | %" + maxPopLength + "d%n", countries [i], populations [i]);
    }
}


