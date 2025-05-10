public static int singleNumber (int [] nums) {
    int answer = 0;
    ArrayList al = new ArrayList ();
    for (int i = 0;
    i < nums.length; i ++) {
        al.add (nums [i]);
    }
    for (int i = 0;
    i < nums.length; i ++) {
        int test = nums [i];
        if (al.indexOf (test) == al.lastIndexOf (test)) {
            answer = nums [i];
        }
    }
    return answer;
}


public static int singleNumber (int [] nums) {
    int answer = 0;
    LinkedHashSet<Integer> hs = new LinkedHashSet<> ();
    for (int i = 0;
    i < nums.length; i ++) {
        hs.add (nums [i]);
    }
    for (int i = 0;
    i < nums.length; i ++) {
        int test = nums [i];
        if (!hs.contains (test)) {
            answer = nums [i];
        }
    }
    return answer;
}
