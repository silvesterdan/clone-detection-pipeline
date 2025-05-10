public int [] solution (String S, int [] P, int [] Q) {
    int [] result = new int [P.length];
    int [] factor1 = new int [S.length ()];
    int [] factor2 = new int [S.length ()];
    int [] factor3 = new int [S.length ()];
    int [] factor4 = new int [S.length ()];
    int factor1Sum = 0;
    int factor2Sum = 0;
    int factor3Sum = 0;
    int factor4Sum = 0;
    for (int i = 0;
    i < S.length (); i ++) {
        switch (S.charAt (i)) {
            case 'A' :
                factor1Sum ++;
                break;
            case 'C' :
                factor2Sum ++;
                break;
            case 'G' :
                factor3Sum ++;
                break;
            case 'T' :
                factor4Sum ++;
                break;
            default :
                break;
        }
        factor1 [i] = factor1Sum;
        factor2 [i] = factor2Sum;
        factor3 [i] = factor3Sum;
        factor4 [i] = factor4Sum;
    }
    for (int i = 0;
    i < P.length; i ++) {
        int start = P [i];
        int end = Q [i];
        if (start == 0) {
            if (factor1 [end] > 0) {
                result [i] = 1;
            } else if (factor2 [end] > 0) {
                result [i] = 2;
            } else if (factor3 [end] > 0) {
                result [i] = 3;
            } else {
                result [i] = 4;
            }
        } else {
            if (factor1 [end] > factor1 [start - 1]) {
                result [i] = 1;
            } else if (factor2 [end] > factor2 [start - 1]) {
                result [i] = 2;
            } else if (factor3 [end] > factor3 [start - 1]) {
                result [i] = 3;
            } else {
                result [i] = 4;
            }
        }
    }
    return result;
}



public int[] solution(String S, int[] P, int[] Q) {
    int[] result = new int[P.length];
    int[] factorCount = {0, 0, 0, 0};
    
    for(int i = 0; i < S.length(); i++){
        switch (S.charAt(i)) {
            case 'A':
                factorCount[0]++;
                break;
            case 'C':
                factorCount[1]++;
                break;
            case 'G':
                factorCount[2]++;
                break;
            case 'T':
                factorCount[3]++;
                break;
        }
        for (int j = 0; j < P.length; j++) {
            int start = P[j];
            int end = Q[j];
            if (i >= start && i <= end) {
                int[] tempFactorCount = new int[4];
                for(int k = 0; k < 4; k++){
                    tempFactorCount[k] = factorCount[k];
                }
                if(tempFactorCount[0] > 0) {
                    result[j] = 1;
                } else if(tempFactorCount[1] > 0) {
                    result[j] = 2;
                } else if(tempFactorCount[2] > 0) {
                    result[j] = 3;
                } else {
                    result[j] = 4;
                }
            }
        }
    }
    return result;
}


