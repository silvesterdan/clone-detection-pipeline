public boolean isPrime () {
    int sqrt = (int) Math.sqrt ((double) value);
    for (int i = 2;
    i <= sqrt; i ++) {
        if (value % i == 0) return false;
    }
    return true;
}


 public boolean isPrime() {
    if(value <= 1) {
        return false;
    }
    for (int i = 2; i * i <= value; i++) {
        if (value % i == 0) { 
            return false; 
        } 
    }
    return true; 
}


