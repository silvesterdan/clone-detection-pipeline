public static void main (String...args) {
    processor = new DefaultProcessor ();
    long [] values = new long [] {0, 4, 10, 12, 100, 108, 299, 1000, 1003, 2040, 45213, 100000, 100005, 100010, 202020, 202022, 999999, 1000000, 1000001, 10000000, 10000007, 99999999, Long.MAX_VALUE, Long.MIN_VALUE};
    String [] strValues = new String [] {"0", "1.30", "0001.00", "3.141592"};
    for (long val : values) {
        System.out.println (val + " = " + processor.getName (val));
    }
    for (String strVal : strValues) {
        System.out.println (strVal + " = " + processor.getName (strVal));
    }
    StringBuilder bigNumber = new StringBuilder ();
    for (int d = 0;
    d < 66; d ++) {
        bigNumber.append ((char) ((Math.random () * 10) + '0'));
    }
    bigNumber.append (".");
    for (int d = 0;
    d < 26; d ++) {
        bigNumber.append ((char) ((Math.random () * 10) + '0'));
    }
    System.out.println (bigNumber.toString () + " = " + processor.getName (bigNumber.toString ()));
}


public static void main (String...args) {
    processor = new DefaultProcessor ();
    long [] values = new long [] {0, 4, 10, 12, 100, 108, 299, 1000, 1003, 2040, 45213, 100000, 100005, 100010, 202020, 202022, 999999, 1000000, 1000001, 10000000, 10000007, 99999999, Long.MAX_VALUE, Long.MIN_VALUE};
    String [] strValues = new String [] {"0", "1.30", "0001.00", "3.141592"};
    for(int x = 0; x < values.length; x++)
    {
      System.out.println (values[x] + " = " + processor.getName (values[x]));
    }
    for(int x = 0; x < strValues.length; x++)
    {
      System.out.println (strValues[x] + " = " + processor.getName (strValues[x]));
    }
    int[] randomDigits = new int[92];
    for(int i = 0; i < randomDigits.length; i++)
    {
        randomDigits[i] = (int)(Math.random()*10);
    }
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < 66; i++) //construct number
    {
        builder.append(randomDigits[i]);
    }
    builder.append(".");
    for(int i = 66; i < 92; i++)
    {
        builder.append(randomDigits[i]);
    }
    System.out.println (builder.toString() + " = " + processor.getName(builder.toString()));
    
}


