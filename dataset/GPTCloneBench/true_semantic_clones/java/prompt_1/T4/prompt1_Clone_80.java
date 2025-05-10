public static void main (String [] args) {
    String str = "abcdabghplhhnfl".toLowerCase ();
    Integer [] ar = new Integer [26];
    for (int i = 0;
    i < str.length (); i ++) {
        int j = str.charAt (i) - 'a';
        if (ar [j] == null) {
            ar [j] = 1;
        } else {
            ar [j] += 1;
        }
    }
    for (int i = 0;
    i < ar.length; i ++) {
        if (ar [i] != null && ar [i] > 1) {
            char c = (char) (97 + i);
            System.out.println ("'" + c + "' comes " + ar [i] + " times.");
        }
    }
}


public static void main (String [] args) {
    String str = "abcdabghplhhnfl".toLowerCase ();
    int[][] ar = new int[26][2];
    for (int i = 0;
    i < str.length (); i ++) {
        int j = str.charAt (i) - 'a';
        if (ar [j][0] == 0) {
            ar [j][0] = 1;
            ar [j][1] = j;
        } else {
            ar [j][0] += 1;
        }
    }
    for (int i = 0;
    i < ar.length; i ++) {
        if (ar [i][0] != 0 && ar [i][0] > 1) {
            char c = (char) (97 + ar[i][1]);
            System.out.println ("'" + c + "' comes " + ar [i][0] + " times.");
        }
    }
}


