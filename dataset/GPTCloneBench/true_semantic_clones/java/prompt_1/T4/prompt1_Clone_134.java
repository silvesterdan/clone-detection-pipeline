public void refund (int balance) {
    while (balance >= 10) {
        System.out.println ("Balance:" + balance);
        balance -= 10;
    }
    while (balance >= 0) {
        System.out.println ("Balance: " + balance);
        balance -= 1;
    }
}


public void refund (int balance) {
    if (balance < 10) {
        while (balance > 0) {
            System.out.println ("Balance: " + balance);
            balance -= 1;
        }
    } else {
        while (balance > 10) {
            System.out.println ("Balance: " + balance);
            balance -= 10;
        }
        while (balance > 0) {
            System.out.println ("Balance: " + balance);
            balance -= 1;
        }
    }
}


