public static void main (String [] args) {
    long twoTo10 = 1024;
    long sum210 = 0;
    for (long i = 1;
    i <= 1000; i ++) {
        sum210 += pow (i, i, twoTo10);
        sum210 %= twoTo10;
    }
    long fiveTo10 = 9_765_625;
    long sum510 = 0;
    for (long i = 1;
    i <= 1000; i ++) {
        sum510 += pow (i, i, fiveTo10);
        sum510 %= fiveTo10;
    }
    long tenTo10 = 10_000_000_000L;
    long answer = sum210 * inverse (fiveTo10, twoTo10) * fiveTo10 + sum510 * inverse (twoTo10, fiveTo10) * twoTo10;
    answer %= tenTo10;
    System.out.println (answer);
}



public static void main (String [] args) {
    long a = 1024;
    long sA = calcSum(1000, a);
    long b = 9_765_625;
    long sB = calcSum(1000, b);
    long c = 10_000_000_000L;
    long res = computeAnswer(sA, sB, a, b, c);
    System.out.println (res);
}


