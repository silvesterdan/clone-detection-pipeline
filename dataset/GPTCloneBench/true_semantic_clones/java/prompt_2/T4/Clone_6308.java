public void filter (String [] words, String text) {
    for (int i = 0;
    i < words.length; i ++) {
        if (text.toLowerCase ().contains (words [i].toLowerCase ())) {
            System.out.println (text);
            break;
        }
    }
}



public void filter(String[] words, String text) {
    for(String word : words) {
        if(text.toLowerCase().contains(word.toLowerCase())) {
            System.out.println(text);
            return;
        }
    }
}


