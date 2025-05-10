public void move (Container container) {
    if (x >= canvasWidth || x <= 0) {
        deltaX = - 1 * deltaX;
    }
    if (y >= canvasHeight || y <= 0) {
        deltaY = - 1 * deltaY;
    }
    x += deltaX;
    y += deltaY;
}


public void move(Container container) {
    if (x >= canvasWidth) {
        deltaX = -1 * deltaX;
    } else if (x <= 0) {
        deltaX = -1 * deltaX;
    }
    if (y >= canvasHeight) {
        deltaY = -1 * deltaY;
    } else if (y <= 0) {
        deltaY = -1 * deltaY;
    }
    x += deltaX;
    y += deltaY;
}


