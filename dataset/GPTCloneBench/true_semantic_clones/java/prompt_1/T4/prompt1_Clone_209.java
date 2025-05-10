public void actionPerformed (ActionEvent e) {
    switch (direction) {
        case UP :
            draw.incrementY (false);
            break;
        case DOWN :
            draw.incrementY (true);
            break;
        case LEFT :
            draw.incrementX (false);
            break;
        case RIGHT :
            draw.incrementX (true);
            break;
        default :
            break;
    }
}


public void actionPerformed (ActionEvent e) {
    if (direction == UP || direction == DOWN) {
        draw.incrementY(direction == DOWN);
    }
    else if (direction == LEFT || direction == RIGHT) {
        draw.incrementX(direction == RIGHT);
    }
}


