public void move () {
    y += ya;
    x += xa;
    if (x < 0) {
        x = 0;
    } else if (x + 30 > game.getWidth ()) {
        x = game.getWidth () - 30;
    }
    if (y < 0) {
        y = 0;
    } else if (collision ()) {
        onGround = true;
        y = game.ground.getBounds ().y - d;
    }
}





public void move () {
    x = xa + x < 0 ? 0 : xa + x;
    if (x + 30 > game.getWidth ())
        x = game.getWidth () - 30;
    y = ya + y < 0 ? 0 : ya + y;
    if (collision ()) {
        onGround = true;
        y = game.ground.getBounds ().y - d;
    }
}


