public static int solution (Integer number) {
    String binary = Integer.toBinaryString (number);
    String [] gaps = binary.split ("1");
    String biggestGap = "";
    for (int i = 0;
    i < (binary.endsWith ("1") ? gaps.length : gaps.length - 1); i ++) {
        if (gaps [i].contains ("0") && gaps [i].length () > biggestGap.length ()) biggestGap = gaps [i];
    }
    return biggestGap.length ();
}


  public static int solution (Integer number) {
    String binary = Integer.toBinaryString (number);
    int maxGap = 0;
    int currentGap = 0;
    for (int i=0; i<binary.length(); i++) {
        if (binary.charAt(i) == '1') {
            if (currentGap > maxGap) {
                maxGap = currentGap;
            }
            currentGap = 0;
        }
        else {
            currentGap++;
        }
    }
    return maxGap;
}


