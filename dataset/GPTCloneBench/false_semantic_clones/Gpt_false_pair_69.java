public void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    tv = new TextView (this);
    this.setContentView (tv);
    SimpleDateFormat formatter = new SimpleDateFormat ("dd.MM.yyyy, HH:mm");
    String oldTime = "19.02.2018, 12:00";
    String NewTime = "20.02.2018, 14:00";
    Date oldDate, newDate;
    try {
        oldDate = formatter.parse (oldTime);
        newDate = formatter.parse (NewTime);
        oldLong = oldDate.getTime ();
        NewLong = newDate.getTime ();
        diff = NewLong - oldLong;
    } catch (ParseException e) {
        e.printStackTrace ();
    }
    MyCount counter = new MyCount (diff, 1000);
    counter.start ();
}


  public void onCreate (Bundle savedInstanceState) {
    super.onCreate (savedInstanceState);
    tv = new TextView (this);
    this.setContentView (tv);
    SimpleDateFormat formatter = new SimpleDateFormat ("yyyy/MM/dd, HH:mm");
    String oldTime = "2018/02/19, 12:00";
    String NewTime = "2018/02/20, 14:00";
    Date oldDate, newDate;
    try {
        oldDate = formatter.parse (oldTime);
        newDate = formatter.parse (NewTime);
        oldLong = oldDate.getTime ();
        NewLong = newDate.getTime ();
        diff = NewLong - oldLong;
    } catch (ParseException e) {
        e.printStackTrace ();
    }
    CalendarCounter timer = new CalendarCounter (diff, 1000);
    timer.start ();
}
