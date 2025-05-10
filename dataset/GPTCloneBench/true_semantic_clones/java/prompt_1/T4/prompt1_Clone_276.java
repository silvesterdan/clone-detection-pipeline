public static void countString (String str, char value) {
    String [] arr = str.split ("");
    StringBuffer tempString = new StringBuffer ();
    for (String s : arr) {
        tempString.append (s);
        for (char ch : s.toCharArray ()) {
            System.out.println ("Number of Occurrence of " + ch + " is:" + tempString.chars ().filter (i -> i == ch).count ());
        }
    }
    if (! (Character.toString (value).isEmpty ())) {
        StringBuffer tempString2 = new StringBuffer ();
        for (String s : arr) {
            tempString2.append (s);
            for (char ch : s.toCharArray ()) {
                if (ch == value) {
                    System.out.println ("Number of Occurrence of " + ch + " is:" + tempString2.chars ().filter (i -> i == ch).count ());
                }
            }
        }
    }
}


public class StringCounter {

    public static void countString (String str, char value) {
        processString (str);
        if (! (Character.toString (value).isEmpty ())) {
            processStringWithChar(str, value);
        }
    }

    private static void processString (String str) {
        String [] arr = str.split ("");
        StringBuffer tempString = new StringBuffer ();
        for (String s : arr) {
           tempString.append (s);
           processChars (s, tempString);
        }
    }

    private static void processChars (String s, StringBuffer tempString) {
        for (char ch : s.toCharArray ()) {
            System.out.println ("Number of Occurrence of " + ch + " is:" + tempString.chars ().filter (i -> i == ch).count ());
        }
    }

    private static void processStringWithChar (String str, char value) {
        String [] arr = str.split ("");
        StringBuffer tempString2 = new StringBuffer ();
        for (String s : arr) {
            tempString2.append (s);
            processCharsWithValue (s, value, tempString2);
        }
    }

    private static void processCharsWithValue (String s, char value, StringBuffer tempString2) {
        for (char ch : s.toCharArray ()) {
            if (ch == value) {
                System.out.println ("Number of Occurrence of " + ch + " is:" + tempString2.chars ().filter (i -> i == ch).count ());
            }
        }
    }

}


