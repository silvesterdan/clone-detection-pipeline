public void actionPerformed (ActionEvent e) {
    int x = (int) (Math.random () * getWidth ());
    int y = (int) (Math.random () * getHeight ());
    int width = (int) (Math.random () * (getWidth () / 4));
    int height = (int) (Math.random () * (getHeight () / 4));
    if (x + width > getWidth ()) {
        x = getWidth () - width;
    }
    if (y + height > getHeight ()) {
        y = getHeight () - height;
    }
    Color color = new Color ((int) (Math.random () * 255), (int) (Math.random () * 255), (int) (Math.random () * 255));
    lstShapes.add (new MyRectangle (x, y, width, height, color));
    repaint ();
}


 public void actionPerformed (ActionEvent e) { 
	int x = (int) (Math.random () * getWidth()) / 2;
    int y = (int) (Math.random () * getHeight()) / 2;
    int widthRange = (int) (Math.random () * getWidth());
	int widthOffset = (int) (widthRange * 0.75);
    int width = widthOffset - (int) (Math.random () * widthRange);
    
    int heightRange = (int) (Math.random () * getHeight());
	int heightOffset = (int) (heightRange * 0.75);
    int height = heightOffset - (int) (Math.random () * heightRange);
    
    Color color = new Color ((int) (Math.random () * 255), (int) (Math.random () * 255), (int) (Math.random () * 255));
    lstShapes.add (new MyRectangle (x, y, width, height, color));
    repaint ();
}


