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



 

public static int singleNumber(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int num : nums) {
        if(set.contains(num)) {
            set.remove(num);
        } else {
            set.add(num);
        }
    }
    return set.iterator().next();
}


