public void paintComponent (Graphics g) {
    super.paintComponent (g);
    Graphics2D gg = (Graphics2D) g;
    gg.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Font font = new Font ("Arial", Font.PLAIN, 15);
    String string = "Time (s)";
    FontMetrics metrics = g.getFontMetrics (font);
    int width = metrics.stringWidth (string);
    int height = metrics.getHeight ();
    gg.setFont (font);
    drawRotate (gg, getWidth (), (getHeight () + width) / 2, 270, string);
}


 public void paintComponent (Graphics g) {
    super.paintComponent (g);
    Graphics2D gg = (Graphics2D) g;
    gg.setRenderingHint (RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
    Font font = new Font ("Helvetica", Font.BOLD, 22);
    String string = "Period (hour)";
    FontMetrics metrics = g.getFontMetrics (font);
    int width = metrics.stringWidth (string);
    int height = metrics.getHeight ();
    gg.setFont (font);
    drawRotate (gg, getWidth (), (getHeight () + width) / 2, 270, string);
}
