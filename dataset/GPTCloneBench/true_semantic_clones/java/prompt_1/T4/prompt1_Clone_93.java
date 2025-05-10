public static void main (String [] args) {
    String test = "The quick brown fox jumped over the lazy dog.";
    int countA = 0, countO = 0, countSpace = 0, countDot = 0;
    for (int i = 0;
    i < test.length (); i ++) {
        switch (test.charAt (i)) {
            case 'a' :
            case 'A' :
                countA ++;
                break;
            case 'o' :
            case 'O' :
                countO ++;
                break;
            case ' ' :
                countSpace ++;
                break;
            case '.' :
                countDot ++;
                break;
        }
    }
    System.out.printf ("%s%d%n%s%d%n%s%d%n%s%d", "A: ", countA, "O: ", countO, "Space: ", countSpace, "Dot: ", countDot);
}


public static void main (String [] args) {
    String test = "The quick brown fox jumped over the lazy dog.";
    Map<String, Integer> countMap = new HashMap<String, Integer>();
    countMap.put("A", 0);
    countMap.put("O", 0);
    countMap.put("Space", 0);
    countMap.put("Dot", 0);
    for (int i = 0;
    i < test.length (); i ++) {
        if (test.charAt(i) == 'a' || test.charAt(i) == 'A') {
            countMap.put("A", countMap.get("A") + 1);
        } 
        else if (test.charAt(i) == 'o' || test.charAt(i) == 'O') {
            countMap.put("O", countMap.get("O") + 1);
        }
        else if (test.charAt(i) == ' ') {
            countMap.put("Space", countMap.get("Space") + 1);
        } 
        else if (test.charAt(i) == '.') {
            countMap.put("Dot", countMap.get("Dot") + 1);
        }
    }
    System.out.print("A: " + countMap.get("A") + "\n");
    System.out.print("O: " + countMap.get("O") + "\n");
    System.out.print("Space: " + countMap.get("Space") + "\n");
    System.out.print("Dot: " + countMap.get("Dot"));
}


