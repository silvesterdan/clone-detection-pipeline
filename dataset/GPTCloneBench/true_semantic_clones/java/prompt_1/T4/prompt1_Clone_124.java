public static void main (String [] argv) {
    int counter = 0;
    for (int year = 1901, last_year = 2000;
    year <= last_year; year ++) {
        for (int month = 1, last_month = 12;
        month <= last_month; month ++) {
            Date d = new GregorianCalendar (year, month - 1, 1).getTime ();
            if (d.getDay () == 0) {
                counter ++;
                System.out.println (String.valueOf (counter) + " " + d);
            }
        }
    }
    System.out.println ("Total sunday in XX century: " + counter);
}


public static void main (String [] argv) {
    int counter = 0;
    int year = 1901, last_year = 2000;
    do {
        int month = 1, last_month = 12;
        do {
            Date d = new GregorianCalendar (year, month - 1, 1).getTime ();
            if (d.getDay () == 0) {
                counter ++;
                System.out.println (String.valueOf (counter) + " " + d);
            }
            month ++;
        } while (month <= last_month);
        year ++;
    } while (year <= last_year);
    System.out.println ("Total sunday in XX century: " + counter);
}


