static String encrypt (String data) {
    String returned = new String ("");
    for (char h : data.toCharArray ()) {
        if (h == 'a') returned += " a', 'c";
        if (h == 'b') returned += "d";
        if (h == 'c') returned += "e";
        if (h == 'd') returned += "f";
        if (h == 'e') returned += "g";
        if (h == 'f') returned += "h";
        if (h == 'g') returned += "i";
        if (h == 'h') returned += "j";
        if (h == 'i') returned += "k";
        if (h == 'j') returned += "l";
        if (h == 'k') returned += "m";
        if (h == 'l') returned += "n";
        if (h == 'm') returned += "o";
        if (h == 'n') returned += "p";
        if (h == 'o') returned += "q";
        if (h == 'p') returned += "r";
        if (h == 'q') returned += "s";
        if (h == 'r') returned += "t";
        if (h == 's') returned += "u";
        if (h == 't') returned += "v";
        if (h == 'u') returned += "w";
        if (h == 'v') returned += "x";
        if (h == 'w') returned += "y";
        if (h == 'x') returned += "z";
        if (h == 'y') returned += "a";
        if (h == 'z') returned += "b";
    }
    return returned;
}


static String encrypt (String data) {
    String returned = new String ("");
    for (char h : data.toCharArray ()) {
        switch (h) {
            case 'a':
                returned += "a', 'c";
                break;
            case 'b':
                returned += "d";
                break;
            case 'c':
                returned += "e";
                break;
            case 'd':
                returned += "f";
                break;
            case 'e':
                returned += "g";
                break;
            case 'f':
                returned += "h";
                break;
            case 'g':
                returned += "i";
                break;
            case 'h':
                returned += "j";
                break;
            case 'i':
                returned += "k";
                break;
            case 'j':
                returned += "l";
                break;
            case 'k':
                returned += "m";
                break;
            case 'l':
                returned += "n";
                break;
            case 'm':
                returned += "o";
                break;
            case 'n':
                returned += "p";
                break;
            case 'o':
                returned += "q";
                break;
            case 'p':
                returned += "r";
                break;
            case 'q':
                returned += "s";
                break;
            case 'r':
                returned += "t";
                break;
            case 's':
                returned += "u";
                break;
            case 't':
                returned += "v";
                break;
            case 'u':
                returned += "w";
                break;
            case 'v':
                returned += "x";
                break;
            case 'w':
                returned += "y";
                break;
            case 'x':
                returned += "z";
                break;
            case 'y':
                returned += "a";
                break;
            case 'z':
                returned += "b";
                break;
        }
    }
    return returned;
}


