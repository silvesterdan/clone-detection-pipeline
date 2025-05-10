public void actionPerformed (ActionEvent e) {
    StringBuilder s = new StringBuilder ();
    s.append (text1.getText ()).append ("\n").append (text2.getText ());
    System.out.println (s.toString ());
}


public void actionPerformed (ActionEvent e) {
    String s = text1.getText () + 
    "\n" + 
    text2.getText ();
    System.out.println (s);
}


