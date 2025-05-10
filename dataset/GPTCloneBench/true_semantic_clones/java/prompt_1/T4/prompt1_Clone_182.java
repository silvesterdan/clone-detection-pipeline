public static int [] removeDuplicates (int [] arr) {
    boolean [] set = new boolean [1001];
    int totalItems = 0;
    for (int i = 0;
    i < arr.length; ++ i) {
        if (! set [arr [i]]) {
            set [arr [i]] = true;
            totalItems ++;
        }
    }
    int [] ret = new int [totalItems];
    int c = 0;
    for (int i = 0;
    i < set.length; ++ i) {
        if (set [i]) {
            ret [c ++] = i;
        }
    }
    return ret;
}


public static int [] removeDuplicates (int [] arr) {
    int len = arr.length;
    Set<Integer> seen = new HashSet<>();
    int totalItems = 0;
    for (int i = 0; i < len; i++){
        boolean check = seen.add(arr[i]);
        if (check == true){
            totalItems++;
        }
    }
    int [] ret = new int [totalItems];
    int c = 0;
    for (int i = 0; i < len; i++) {
        if (seen.contains(arr[i])) {
            ret[c] = arr[i];
            c++;
        }
    }
    return ret;
}


