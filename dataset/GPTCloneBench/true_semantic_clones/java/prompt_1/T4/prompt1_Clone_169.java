public boolean haveThree (int [] nums) {
    int count = 0;
    boolean flag = false;
    for (int i = 0;
    i < nums.length; i ++) {
        if (nums [i] == 3) {
            if (flag) {
                return false;
            } else {
                count ++;
                flag = true;
            }
        } else {
            flag = false;
        }
    }
    return count == 3;
}


public boolean haveThree (int [] nums) {
    int count = 0;
    for (int i = 0;
    i < nums.length; i ++) {
        if (nums [i] == 3) {
            count ++;
            if (count > 2) {
                return false;
            }
        }
    }
    return count == 3;
}


