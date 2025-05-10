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
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length; i++ ) {
        if (i == input.length - 1) {
            sb.append(input[i]);
        } else {
            sb.append(input[i]).append(delimiter);
        }
    }
    return sb.toString();
}


