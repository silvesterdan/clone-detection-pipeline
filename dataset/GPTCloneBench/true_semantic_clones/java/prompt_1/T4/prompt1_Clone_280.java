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


public int [] solution (String S, int [] P, int [] Q) {
    char [] c = S.toCharArray();
    int [] input = new int[c.length];
    for (int i = 0; i < c.length; ++i) 
        input[i] = characterMapping.get(c[i]);

    int [] result = new int [P.length];
    for (int i = 0; i < P.length; ++i) {
        if (P[i] == Q[i]) {
            result[i] = input[P[i]];
            break;
        }
        int [] subArray = Arrays.copyOfRange(input, P[i], Q[i]+1);
        int minVal = minimum(subArray);
        result[i] = minVal;
    }
    return result;
}


