public static Calendar getLastFriday (Calendar cal, int offset) {
    int dayofweek;
    cal.set (Calendar.MONTH, cal.get (Calendar.MONTH) + offset);
    cal.set (Calendar.DAY_OF_MONTH, cal.getActualMaximum (Calendar.DAY_OF_MONTH));
    dayofweek = cal.get (Calendar.DAY_OF_WEEK);
    if (dayofweek < Calendar.FRIDAY) cal.set (Calendar.DAY_OF_MONTH, cal.get (Calendar.DAY_OF_MONTH) - 7 + Calendar.FRIDAY - dayofweek);
    else cal.set (Calendar.DAY_OF_MONTH, cal.get (Calendar.DAY_OF_MONTH) + Calendar.FRIDAY - dayofweek);
    return cal;
}


public static Calendar getLastSaturday (Calendar cal, int offset) {
    int dayofweek;
    cal.set (Calendar.MONTH, cal.get (Calendar.MONTH) + offset);
    cal.set (Calendar.DAY_OF_MONTH, cal.getActualMaximum (Calendar.DAY_OF_MONTH));
    dayofweek = cal.get (Calendar.DAY_OF_WEEK);
    if (dayofweek < Calendar.SATURDAY) cal.set (Calendar.DAY_OF_MONTH, cal.get (Calendar.DAY_OF_MONTH) - 7 + Calendar.SATURDAY - dayofweek);
    else cal.set (Calendar.DAY_OF_MONTH, cal.get (Calendar.DAY_OF_MONTH) + Calendar.SATURDAY - dayofweek);
    return cal;
}
