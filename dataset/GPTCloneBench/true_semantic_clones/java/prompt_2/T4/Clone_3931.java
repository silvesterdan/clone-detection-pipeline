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





public void move() {
    x = Math.max(x + xa, 0);
    x = Math.min(x, game.getWidth() - 30);

    y = Math.max(y + ya, 0);
    if (collision()) {
        onGround = true;
        y = game.ground.getBounds().y - d;
    }
}


