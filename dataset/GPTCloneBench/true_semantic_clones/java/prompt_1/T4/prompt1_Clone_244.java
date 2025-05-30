public static String removeAdjacentDuplicates (String input) {
    if (input.length () <= 1) {
        return input;
    }
    StringBuilder sb = new StringBuilder ();
    sb.append (input.charAt (0));
    IntStream.range (1, input.length ()).mapToObj (i -> input.charAt (i) != input.charAt (i - 1) ? input.charAt (i) : "").forEach (sb :: append);
    return sb.toString ();
}


public static String removeAdjacentDuplicates (String input) {
    if (input.length () <= 1) {
        return input;
    }
    String result = input.substring (0, 1);
    IntStream.range (1, input.length ()).mapToObj (i -> input.charAt (i) != input.charAt (i - 1) ? input.charAt (i) : "")
            .reduce (result,(acc, curr) -> acc + curr);
    return result;
}


