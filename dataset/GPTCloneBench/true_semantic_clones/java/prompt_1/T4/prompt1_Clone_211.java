public static void main (final String [] args) {
    final Console console = System.console ();
    if (console != null) {
        final SortNames sortNames = new SortNames (console);
        sortNames.run ();
    } else {
        System.err.println ("Sorry, no console.");
        System.exit (1);
    }
}


public static void main (final String [] args) {
    final Console console;
    if (System.console () != null) {
        console = System.console ();
    } else {
        System.err.println ("Sorry, no console.");
        System.exit (1);
    }
    final SortNames sortNames = new SortNames (console);
    sortNames.run ();
}


