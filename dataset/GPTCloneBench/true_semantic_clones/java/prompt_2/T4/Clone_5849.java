public static int evenDigits (int n) {
    if ((n & 1) != 0) {
        return evenDigits (n / 10);
    }
    if (n < 10) {
        return n;
    }
    return n % 10 + evenDigits (n / 10) * 10;
}





public static int evenDigits (int n) {
    return ((n & 1) != 0) ? evenDigits (n / 10) : ((n < 10) ? n : n % 10 + evenDigits (n / 10) * 10);
}


