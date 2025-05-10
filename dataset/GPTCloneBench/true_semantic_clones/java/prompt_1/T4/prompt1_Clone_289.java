public int tortoiseMoves () {
    switch (tGen ()) {
        case 1 :
        case 2 :
        case 3 :
        case 4 :
        case 5 :
            return 3;
        case 6 :
        case 7 :
        case 8 :
            return 1;
        case 9 :
        case 10 :
            return - 6;
        default :
            return 0;
    }
}


public int tortoiseMoves () {
    int ret;
    if (tGen () == 1 || tGen () == 2 || tGen () == 3 || tGen () == 4 || tGen () == 5) {
        ret = 3;
    }
    else if (tGen () == 6 || tGen () == 7 || tGen () == 8) {
        ret = 1;
    }
    else if (tGen () == 9 || tGen () == 10) {
        ret = - 6;
    }
    else {
        ret = 0;
    }
    return ret;
}


