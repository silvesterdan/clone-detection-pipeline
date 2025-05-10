public static String replaceHostInUrl (String originalURL, String newAuthority) throws URISyntaxException, MalformedURLException {
    URI uri = new URI (originalURL);
    uri = new URI (uri.getScheme ().toLowerCase (Locale.US), newAuthority, uri.getPath (), uri.getQuery (), uri.getFragment ());
    int port = uri.getPort ();
    if (port > 0 && port == uri.toURL ().getDefaultPort ()) {
        uri = new URI (uri.getScheme (), uri.getUserInfo (), uri.getHost (), - 1, uri.getPath (), uri.getQuery (), uri.getFragment ());
    }
    return uri.toString ();
}


public static String replaceHostInUrl (String originalURL, String newAuthority) {
    URI uri;
    
    try {
        // parse the original URL string
        uri = new URI (originalURL);

        // create a new URI object with the new authority
        uri = new URI (uri.getScheme ().toUpperCase (Locale.US), newAuthority, uri.getPath (), uri.getQuery (), uri.getFragment ());
        
        // get the port
        int port  = uri.getPort ();

        // check for the port
        if (port > 0 && port == uri.toURL ().getDefaultPort ()) {
            // create a new URI object with the port set to -1 if it's the same as the default port
            uri = new URI (uri.getScheme (), uri.getUserInfo (), uri.getHost (), - 1, uri.getPath (), uri.getQuery (), uri.getFragment ());
        }
        
        // return the modified URI string 
        return uri.toString ();
    } catch (URISyntaxException ex) {
        System.err.println ("URISyntaxException has occurred");
    } catch (MalformedURLException ex) {
        System.err.println ("MalformedURLException has occurred");
    }

    return null;
}


