public static String getDurationBreakdown (long millis) {
    if (millis < 0) {
        throw new IllegalArgumentException ("Duration must be greater than zero!");
    }
    long days = TimeUnit.MILLISECONDS.toDays (millis);
    millis -= TimeUnit.DAYS.toMillis (days);
    long hours = TimeUnit.MILLISECONDS.toHours (millis);
    millis -= TimeUnit.HOURS.toMillis (hours);
    long minutes = TimeUnit.MILLISECONDS.toMinutes (millis);
    millis -= TimeUnit.MINUTES.toMillis (minutes);
    long seconds = TimeUnit.MILLISECONDS.toSeconds (millis);
    StringBuilder sb = new StringBuilder (64);
    sb.append (days);
    sb.append (" Days ");
    sb.append (hours);
    sb.append (" Hours ");
    sb.append (minutes);
    sb.append (" Minutes ");
    sb.append (seconds);
    sb.append (" Seconds");
    return (sb.toString ());
}


public static String getDurationBreakdown(long millis) {
    if (millis < 0) {
        throw new IllegalArgumentException("Duration must be greater than zero!");
    }
    long days = TimeUnit.MILLISECONDS.convert(millis, TimeUnit.DAYS);
    millis -= TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
    long hours = TimeUnit.MILLISECONDS.convert(millis, TimeUnit.HOURS);
    millis -= TimeUnit.HOURS.convert(hours, TimeUnit.MILLISECONDS);
    long minutes = TimeUnit.MILLISECONDS.convert(millis, TimeUnit.MINUTES);
    millis -= TimeUnit.MINUTES.convert(minutes, TimeUnit.MILLISECONDS);
    long seconds = TimeUnit.MILLISECONDS.convert(millis, TimeUnit.SECONDS);
    StringBuilder sb = new StringBuilder(64);
    sb.append(days).append(" Days ").append(hours).append(" Hours ").append(minutes).append(" Minutes ").append(seconds).append(" Seconds");
    return sb.toString();
}


