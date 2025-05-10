public static void main (String [] args) {
    int [] coins = new int [] {1, 2, 3, 4, 5};
    int money = 600;
    int [] [] recorder = new int [money + 1] [coins.length];
    for (int k = 0;
    k < coins.length; k ++) {
        recorder [0] [k] = 1;
    }
    for (int i = 1;
    i <= money; i ++) {
        int with = 0;
        int without = 0;
        for (int coin_index = 0;
        coin_index < coins.length; coin_index ++) {
            if (i - coins [coin_index] < 0) {
                with = 0;
            } else {
                with = recorder [i - coins [coin_index]] [coin_index];
            }
            if (coin_index - 1 < 0) {
                without = 0;
            } else {
                without = recorder [i] [coin_index - 1];
            }
            recorder [i] [coin_index] = with + without;
        }
    }
    System.out.print (recorder [money] [coins.length - 1]);
}


public static void main (String [] args) {
    int [] coins = new int [] {1, 2, 3, 4, 5};
    int money = 600;
    int [] [] recorded = new int [money + 1] [coins.length];
    for (int k = 0;
    k < coins.length; k ++) {
        recorded [0] [k] = 1;
    }
    for (int i = 1;
    i <= money; i ++) {
        for (int coin_idx = 0;
        coin_idx < coins.length; coin_idx ++) {
            int with, without;
            with = (i - coins [coin_idx] < 0) ? 0 : recorded [i - coins [coin_idx]] [coin_idx];
            without = (coin_idx - 1 < 0) ? 0 : recorded [i] [coin_idx -1];
            recorded [i] [coin_idx] = with + without;
        }
    }
    System.out.print (recorded [money] [coins.length - 1]);
}


