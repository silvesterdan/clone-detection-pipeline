public void mouseDragged (MouseEvent e) {
    JViewport vport = (JViewport) e.getSource ();
    JComponent label = (JComponent) vport.getView ();
    Point cp = e.getPoint ();
    Point vp = vport.getViewPosition ();
    vp.translate (pp.x - cp.x, pp.y - cp.y);
    label.scrollRectToVisible (new Rectangle (vp, vport.getSize ()));
    pp.setLocation (cp);
}


public void mouseDragged (MouseEvent event) {
    Component vport = event.getSource;
    Component label = vport.getView;
    Point currentPoint = event.getPoint;
    Point viewPoint = vport.getViewPosition;
    viewPoint.translate (pp.x - currentPoint.x, pp.y - currentPoint.y);
    label.scrollRectToVisible (new Rectangle (viewPoint, vport.getSize));
    pp.setLocation (currentPoint);
}


