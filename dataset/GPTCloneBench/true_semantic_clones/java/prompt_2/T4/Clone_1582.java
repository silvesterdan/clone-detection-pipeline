public static void printTable (String [] countries, int [] populations) {
    int defaultLength = 10;
    int maxCountryLength = stream (countries).mapToInt (String :: length).max ().orElse (defaultLength);
    int maxPopulationLength = stream (populations).mapToObj (Integer :: toString).mapToInt (String :: length).max ().orElse (defaultLength);
    for (int i = 0;
    i < countries.length; i ++) {
        System.out.format ("%-" + maxCountryLength + "s | %" + maxPopulationLength + "d\n", countries [i], populations [i]);
    }
}


 
public static void printTable(String[] countries, int[] populations) {
    int defaultLength = 10;
    int maxCountryLength = Stream.of(countries).mapToInt(String::length).max().orElse(defaultLength);
    int maxPopulationLength = Stream.of(populations).mapToObj(Integer::toString).mapToInt(String::length).max().orElse(defaultLength);
    String format = String.format("%%-%ds | %%%dd\n", maxCountryLength, maxPopulationLength);
    for (int i = 0; i < countries.length; i++) {
        System.out.format(format, countries[i], populations[i]);
    }
}


