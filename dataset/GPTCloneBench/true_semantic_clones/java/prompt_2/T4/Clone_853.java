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


 public static void main(String... args) {
    processor = new DefaultProcessor();
    long[] values = {0, 4, 10, 12, 100, 108, 299, 1000, 1003, 2040, 45213, 100000, 100005, 100010, 202020, 202022, 999999, 1000000, 1000001, 10000000, 10000007, 99999999, Long.MAX_VALUE, Long.MIN_VALUE};
    String[] strValues = {"0", "1.30", "0001.00", "3.141592"};
    for (long val : values) {
        String valString = String.valueOf(val);
        System.out.printf("%s = %s\n", valString, processor.getName(valString));
    }
    for (String strVal : strValues) {
        System.out.printf("%s = %s\n", strVal, processor.getName(strVal));
    }
    StringBuilder bigNumber = new StringBuilder();
    for (int d = 0; d < 66; d++) {
        int randomNumber = (int)(Math.random() * 10) + 48;
        bigNumber.append((char) randomNumber);
    }
    bigNumber.append(".");
    for (int d = 0; d < 26; d++) {
        int randomNumber = (int)(Math.random() * 10) + 48;
        bigNumber.append((char) randomNumber);
    }
    System.out.printf("%s = %s\n", bigNumber.toString(), processor.getName(bigNumber.toString()));
}


