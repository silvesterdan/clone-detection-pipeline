public static void printTable (String [] countries, int [] populations) {
    int defaultLength = 10;
    int maxCountryLength = stream (countries).mapToInt (String :: length).max ().orElse (defaultLength);
    int maxPopulationLength = stream (populations).mapToObj (Integer :: toString).mapToInt (String :: length).max ().orElse (defaultLength);
    for (int i = 0;
    i < countries.length; i ++) {
        System.out.format ("%-" + maxCountryLength + "s | %" + maxPopulationLength + "d\n", countries [i], populations [i]);
    }
}


public static void printTable (String [] countries, int [] populations) {
    int defaultLength = 10;
    int maxCountryLength = -1;
    for (String country : countries)
        maxCountryLength = Math.max (maxCountryLength, country.length ());
    maxCountryLength = Math.max (maxCountryLength, defaultLength);
    int maxPopulationLength = -1;
    for (int population : populations)
        maxPopulationLength = Math.max (maxPopulationLength, Integer.toString (population).length ());
    maxPopulationLength = Math.max (maxPopulationLength, defaultLength);
    for (int i = 0;
    i < countries.length; i ++) {
        System.out.format ("%-" + maxCountryLength + "s | %" + maxPopulationLength + "d\n", countries [i], populations [i]);
    }
}


