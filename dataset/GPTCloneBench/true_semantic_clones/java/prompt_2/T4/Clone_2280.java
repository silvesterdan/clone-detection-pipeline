public static void main (String [] args) throws ParseException {
    String st1 = "2015-07-24T09:39:14.000Z";
    String st2 = "2015-07-24T09:45:44.000Z";
    String time1 = st1.substring (st1.indexOf ("T") + 1, st1.indexOf (".0"));
    String time2 = st2.substring (st2.indexOf ("T") + 1, st2.indexOf (".0"));
    Date dateTime1 = new java.text.SimpleDateFormat ("HH:mm").parse (time1);
    Date dateTime2 = new java.text.SimpleDateFormat ("HH:mm").parse (time2);
    System.out.println (dateTime1.after (dateTime2));
}


 public static void main (String [] args) throws ParseException {
    //Parse the String
	String st1 = "2015-07-24T09:39:14.000Z";
	String st2 = "2015-07-24T09:45:44.000Z";

    //Parse the strings and split them into two parts, one for the date and one for the time
	String [] dateAndTime1 = st1.split("T");
	String [] dateAndTime2 = st2.split("T");

    //Create substrings for each of the datetimes
	String time1 = dateAndTime1[1].substring(0, dateAndTime1[1].indexOf(".0"));
	String time2 = dateAndTime2[1].substring(0, dateAndTime2[1].indexOf(".0"));

    //Create MonthDay objects for each of the datetimes
	MonthDay dateTime1 = MonthDay.parse(time1);
	MonthDay dateTime2 = MonthDay.parse(time2);

    //Compare two MonthDay objects
	System.out.println (dateTime1.isAfter(dateTime2));
}


