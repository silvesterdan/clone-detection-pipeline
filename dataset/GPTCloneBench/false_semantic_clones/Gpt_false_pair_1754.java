public static void main (String [] args) {
    try {
        ArrayList < String > sentences = null;
        sentences = new ArrayList < String > ();
        sentences.add ("Mary and Meera are my classmates.");
        sentences.add ("Mary and Meera are my classmates.");
        sentences.add ("Meera and Mary are my classmates.");
        sentences.add ("Alice and Bobe are not my classmates.");
        sentences.add ("Some totally different sentence.");
        wordAnalyser (sentences);
    } catch (Exception e) {
        e.printStackTrace ();
    }
}


  public static void main (String [] args) {
    try {
        ArrayDeque < String > sentences = null;
        sentences = new ArrayDeque < String > ();
        sentences.addFirst ("Mary and Meera are my classmates.");
        sentences.addLast ("Mary and Meera are my classmates.");
        sentences.add ("Meera and Mary are my classmates.");
        sentences.add ("Alice and Bobe are not my classmates.");
        sentences.add ("Some totally different sentence.");
        wordAnalyser (sentences);
    } catch (Exception e) {
        e.printStackTrace ();
    }
}
