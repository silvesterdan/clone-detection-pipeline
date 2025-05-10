public int [] solution (String S, int [] P, int [] Q) {
    final char [] characterInput = S.toCharArray ();
    final int [] integerInput = new int [characterInput.length];
    for (int counter = 0;
    counter < characterInput.length; counter ++) {
        integerInput [counter] = characterMapping.get (characterInput [counter]);
    }
    int [] result = new int [P.length];
    for (int index = 0;
    index < P.length; index ++) {
        if (P [index] == Q [index]) {
            result [index] = integerInput [P [index]];
            break;
        }
        final int [] subArray = Arrays.copyOfRange (integerInput, P [index], Q [index] + 1);
        final int minimumValue = minimum (subArray);
        result [index] = minimumValue;
    }
    return result;
}


public int [] resolve (String S, int [] P, int [] Q) {
    char [] c = S.toCharArray();
    int [] integer = new int[c.length];
    for (int iter = 0; iter < c.length; ++iter) 
        integer[iter] = characterMapping.get(c[iter]);
    int [] finalResult = new int [P.length];
    for (int iter = 0; iter < P.length; ++iter) {
        if (P[iter] == Q[iter]) {
            finalResult[iter] = integer[P[iter]];
            break;
        }
        int [] subArr = Arrays.copyOfRange(integer, P[iter], Q[iter]+1);
        int minVal = minimum(subArr);
        finalResult[iter] = minVal;
    }
    return finalResult;
}


