public static String output (String [] fourLetter, String [] fiveLetter, String [] sixLetter) {
    String answer = "";
    int count = 1;
    for (int i = 0;
    i < Math.max (Math.max (fourLetter.length, fiveLetter.length), sixLetter.length); i ++) {
        if (sixLetter.length > i) {
            answer += sixLetter [i] + " ";
        }
        if (fiveLetter.length > i) {
            answer += fiveLetter [i] + " ";
        }
        if (fourLetter.length > i) {
            answer += fourLetter [i];
        }
        answer += "\n";
        for (int j = 0;
        j < count; j ++) {
            answer += "\t";
        }
        count ++;
    }
    return answer;
}


    public static String output(String[] fourLetter, String[] fiveLetter, String[] sixLetter) {
        StringBuilder sb = new StringBuilder();
        int tabCount = 1;
        int maxLength = Math.max (Math.max (fourLetter.length, fiveLetter.length), sixLetter.length);
        for (int i = 0; i < maxLength; i++) {
            if (sixLetter.length > i) {
                sb.append (sixLetter[i]);
            }
            if (fiveLetter.length > i) {
                sb.append (" ");
                sb.append (fiveLetter[i]);
            }
            if (fourLetter.length > i) {
                sb.append (" ");
                sb.append (fourLetter[i]);
            }
            for (int j = 0; j < tabCount; j++) {
                sb.append ("\t");
            }
            tabCount++;
            sb.append ("\n");
        }
        return sb.toString();
}


