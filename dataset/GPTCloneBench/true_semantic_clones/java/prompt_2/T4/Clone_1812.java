int findCombinationsCount (int amount, int coins [], int checkFromIndex) {
    if (amount == 0) return 1;
    else if (amount < 0 || coins.length == checkFromIndex) return 0;
    else {
        int withFirstCoin = findCombinationsCount (amount - coins [checkFromIndex], coins, checkFromIndex);
        int withoutFirstCoin = findCombinationsCount (amount, coins, checkFromIndex + 1);
        return withFirstCoin + withoutFirstCoin;
    }
}




int findCombinationsCount (int amount, int coins [], int checkFromIndex) {
    if (checkFromIndex == coins.length && amount != 0) return 0;
    else if (amount == 0) return 1;
    else {
        int withFirstCoin = findCombinationsCount (amount - coins [checkFromIndex], coins, checkFromIndex + 1);
        int withoutFirstCoin = findCombinationsCount (amount, coins, checkFromIndex);
        return withFirstCoin + withoutFirstCoin;
    }
}


