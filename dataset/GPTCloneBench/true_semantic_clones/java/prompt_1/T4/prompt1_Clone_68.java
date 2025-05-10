private static int solution (int N) {
    int gap = 0;
    String binaryStr = Integer.toBinaryString (N);
    String [] zeroArrays = binaryStr.split ("1");
    System.out.println (Arrays.toString (zeroArrays));
    for (String zeroArray : zeroArrays) {
        gap = zeroArray.length () > gap ? zeroArray.length () : gap;
    }
    return gap;
}


private static int solution (int N) {
    int gap = 0;
    String binaryStr = Integer.toBinaryString (N);
    char[] binaryStrChars = binaryStr.toCharArray();
    int length = binaryStrChars.length;
    int[] oneIndices = new int[length]; 
    int zeroLength;
    int j = 0;
    for(int i = 0; i < length; i++) {
        if (binaryStrChars[i] == '1') { 
            oneIndices[j] = i; 
            j++;
        }
    }
    for(int i = 0; i < j-1; i++){
        zeroLength = oneIndices[i+1] - oneIndices[i] - 1;
        gap = zeroLength > gap ? zeroLength : gap;
    }
    return gap;
}


