public void isAvailable () {
    URL url = new URL ("URL HERE");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
    connection.setRequestProperty ("Connection", "close");
    connection.setConnectTimeout (10000);
    connection.connect ();
    if (connection.getResponseCode () == 200) {
        return true;
    } else return false;
}


public boolean isAvailable () {
    URL url;
    HttpURLConnection connection;

    try {
        url = new URL ("URL HERE");
        connection = (HttpURLConnection) url.openConnection ();
        connection.setRequestProperty ("Connection", "close");
        connection.setConnectTimeout (10000);
        connection.connect ();
        if (connection.getResponseCode () == 200) {
            return true;
        } else {
            return false;
        }
    } catch (IOException e) {
        e.printStackTrace ();
        return false;
    }
}


