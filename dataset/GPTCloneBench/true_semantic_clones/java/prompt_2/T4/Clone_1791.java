public static void main (String [] args) {
    String x = "gdfg";
    System.out.println ("x length: " + x.length ());
    String [] lines = Split (x, 30, 210);
    for (int i = 0;
    i < lines.length; i ++) {
        System.out.println ("lines[" + i + "]: (len: " + lines [i].length () + ") : " + lines [i]);
    }
}



 public static void main(String [] args){
    String x = "gdfg";
    int xLength = x.length();
    System.out.println("x length: " + xLength);
    System.out.println();
    String[] xLines = Split(x, 30, 210);
    for(int i=0; i<xLines.length; i++){
        int lineLength = xLines[i].length();
        System.out.println("lines[" + i + "]: (len: " + lineLength + ") : " + xLines[i]);
    }
}


