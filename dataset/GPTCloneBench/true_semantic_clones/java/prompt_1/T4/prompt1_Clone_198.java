public static void main (String [] args) {
    String set = new java.util.BitSet () {
        {
            set (1, 100 + 1);
        }
    }
    .toString ();
    System.out.append (set, 1, set.length () - 1);
}


public class Main {
    public static void main(String[] args) {
        initializeSet();
        printToConsole();
    }

    public static void initializeSet() {
        String set = new java.util.BitSet () {
            {
                set (1, 100 + 1);
            }
        }
        .toString ();
    }

    public static void printToConsole(){
        System.out.append (set, 1, set.length () - 1);
    }
}


