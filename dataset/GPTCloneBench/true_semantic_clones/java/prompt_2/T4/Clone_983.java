public void refund (int balance) {
    while (balance >= 10) {
        System.out.println ("Balance: " + balance);
        balance -= 10;
    }
    while (balance >= 0) {
        System.out.println ("Balance: " + balance);
        balance -= 1;
    }
}


  public void refund (int balance) {
    while (balance >= 0) {
        System.out.println("Balance: " + Math.max(balance,10));
        balance -= 10;
    }
}


