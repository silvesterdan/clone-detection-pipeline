public void mouseMoved (MouseEvent e) {
    xpos = getX ();
    if (xpos < 0) {
        polyrot --;
    } else if (xpos > 0) {
        polyrot ++;
    }
    repaint ();
    break;
}


public void mouseMoved (MouseEvent e) {
    int xpos = getX ();
    if (xpos < 0) {
        if (polyrot > 0)
            polyrot--;
    } else {
        if (polyrot < 0)
            polyrot++;
    }
    repaint ();
}


