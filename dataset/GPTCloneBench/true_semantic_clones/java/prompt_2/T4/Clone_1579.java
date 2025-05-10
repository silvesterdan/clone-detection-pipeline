public static void printTable (String [] countries, int [] populations) {
    if (countries.length != 0) {
        int longestNameInput = countries [0].length ();
        int longestPopInput = String.valueOf (populations [0]).length ();
        for (int i = 0;
        i < countries.length; i ++) {
            int countLength = countries [i].length ();
            int popLength = String.valueOf (populations [i]).length ();
            if (countLength > longestNameInput) longestNameInput = countLength;
            if (popLength > longestPopInput) longestPopInput = popLength;
        }
        for (int i = 0;
        i < countries.length; i ++) {
            System.out.print (countries [i]);
            for (int j = 0;
            j < (longestNameInput - countries [i].length ()); j ++) System.out.print (" ");
            System.out.print (" | ");
            for (int k = 0;
            k < (longestPopInput - String.valueOf (populations [i]).length ()); k ++) System.out.print (" ");
            System.out.println (populations [i]);
        }
    }
}


  public static void printTable (String [] countries, int [] populations) {
    if (countries.length != 0) {
        int maxNameLength = 0;
        int maxPopLength = 0;
        for (int i = 0; i < countries.length; i++) {
            int nameLength = countries[i].length();
            int populationLength = String.valueOf(populations[i]).length();
            maxNameLength = Math.max(maxNameLength, nameLength);
            maxPopLength = Math.max(maxPopLength, populationLength);
        }
        for (int i = 0; i < countries.length; i++) {
            String output = String.format("%-" + (maxNameLength+3) + "s | %" + (maxPopLength + 1) + "d", countries[i], populations[i]);
            System.out.println(output);
        }
    }
}


