public static String compress (String text) {
    String result = "";
    int index = 0;
    while (index < text.length ()) {
        char c = text.charAt (index);
        int count = count (text, index);
        if (count == 1) result += "" + c;
        else result += "" + count + c;
        index += count;
    }
    return result;
}




public static String concatenate(String result, int count, char c) {
            if (count == 1) result += "" + c;
            else result += "" + count + c;
            return result;
        }

        public static String compress(String text) {
            String result = "";
            for (int index = 0; index < text.length();) {
                char c = text.charAt(index);
                int count = count(text, index);
                result = concatenate(result, count, c);
                index += count;
            }
            return result;
}


