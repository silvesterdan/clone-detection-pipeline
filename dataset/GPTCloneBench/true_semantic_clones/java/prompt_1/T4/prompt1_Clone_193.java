private String join (String [] input, String delimiter) {
    StringBuilder sb = new StringBuilder ();
    for (String value : input) {
        sb.append (value);
        sb.append (delimiter);
    }
    int length = sb.length ();
    if (length > 0) {
        sb.setLength (length - delimiter.length ());
    }
    return sb.toString ();
}


private String join(String[] input, String delimiter) { 
    String result = "";
    for (String value : input) {
        result = result + value + delimiter;
    }
    int length = result.length();
    if (length > 0) {
        result = result.substring(0, length - delimiter.length());
    }
    return result;
}


