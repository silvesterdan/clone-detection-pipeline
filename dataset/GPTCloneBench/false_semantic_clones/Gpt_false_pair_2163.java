public void actionPerformed (ActionEvent e) {
    ImageIcon widthIcon = new ImageIcon ("LR-arrows.png");
    String scaleWidth = (String) JOptionPane.showInputDialog (null, "What should the new width be?", "", JOptionPane.QUESTION_MESSAGE, widthIcon, null, null);
    ImageIcon heightIcon = new ImageIcon ("UD-arrows.png");
    String scaleHeight = (String) JOptionPane.showInputDialog (null, "What should the new height be?", "", JOptionPane.QUESTION_MESSAGE, widthIcon, null, null);
    double x = Double.parseDouble (scaleWidth);
    double y = Double.parseDouble (scaleHeight);
    int newWidth = (int) x;
    int newHeight = (int) y;
    frame.setSize (newWidth, newHeight);
    scale (newWidth, newHeight);
}


 public void actionPerformed (ActionEvent e) {
        ImageIcon widthIcon = new ImageIcon ("LR-arrows.png");
        String scaleWidth = (String) JOptionPane.showInputDialog (null, "Input the desired width for the image.", "Input Width", JOptionPane.QUESTION_MESSAGE, widthIcon, null, null);
        ImageIcon heightIcon = new ImageIcon ("UD-arrows.png");
        String scaleHeight = (String) JOptionPane.showInputDialog (null, "What should the new height be?", "Input Height", JOptionPane.QUESTION_MESSAGE, widthIcon, null, null);
        double x = Double.parseDouble (scaleWidth);
        double y = Double.parseDouble (scaleHeight);
        int newWidth = (int) x;
        int newHeight = (int) y;
        frame.setSize (newWidth, newHeight);
        scale (newWidth, newHeight);
}
