public static boolean twoDuplicates (int [] values) {
    for (int i = 0;
    i < values.length; i ++) {
        int counter = 0;
        for (int z = i + 1;
        z <= values.length - 1; z ++) {
            if (values [i] == values [z]) {
                counter ++;
                if (counter == 2) return true;
            }
        }
    }
    return false;
}


 public static boolean twoDuplicates(int[] values) {
    for (int i = 0; i < values.length - 1; i++) {
        for (int j = i + 1; j < values.length; j++) {
            if (values[i] == values[j]) {
                int count = 0;
                for (int k = 0; k < values.length; k++) {
                    if (values[i] == values[k]) {
                        count++;
                        if (count == 2) {
                            return true;
                        }
                    }
                }
                break;
            }
        }
    }
    return false;
}


