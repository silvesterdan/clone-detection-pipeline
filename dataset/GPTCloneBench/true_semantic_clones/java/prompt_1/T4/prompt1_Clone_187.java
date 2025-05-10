public void characters (char ch [], int start, int length) throws SAXException {
    tmpElementValue = new String (
        ch, 
        start, 
        length
    );
}


public void characters (char ch [], int start, int length) throws SAXException {
     tmpElementValue = new StringBuffer (
        ch, 
        start, 
        length).toString();
}


