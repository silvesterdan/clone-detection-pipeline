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
    ArrayList <Integer> countsArr = new ArrayList<>();
    char[] ch = binaryStr.toCharArray();
    int count = 0;
    for(int i=0;i<ch.length;i++){
        if(ch[i]=='0'){
            count++;
        }else{
            countsArr.add(count);
            count = 0;
        }
    }
    System.out.println(countsArr.toString());
    for (int each : countsArr) {
        gap = each > gap ? each : gap;
    }
    return gap;
}


