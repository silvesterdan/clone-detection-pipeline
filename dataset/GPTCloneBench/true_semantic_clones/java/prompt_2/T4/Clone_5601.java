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
    int maxLength = 10;
    int maxLengthCountry = java.util.stream.Stream.of(countries).mapToInt(String::length).max().orElse(maxLength);
    int maxLengthPopulation = java.util.stream.Stream.of(populations).mapToObj(Integer::toString).mapToInt(String::length).max().orElse(maxLength);
    java.util.stream.IntStream.range(0, countries.length).forEach(i -> System.out.printf("%-" + maxLengthCountry + "s | %" + maxLengthPopulation + "d\n", countries[i], populations[i]));
}


