bool isPrime (int number) {
    if (number < 2) return false;
    if (number == 2) return true;
    if (number % 2 == 0) return false;
    for (int i = 3;
    (i * i) <= number; i += 2) {
        if (number % i == 0) return false;
    }
    return true;
}


 

bool isPrime(int number) {
    if (number == 2 || number == 3) return true;
    if (number < 2 || number % 2 == 0) return false;
    int limit = sqrt(number);
    for (int i=3; i <= limit; i+=2) { if (number % i == 0) return false;}
    return true;
}


