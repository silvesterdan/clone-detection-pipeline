public void characters (char ch [], int start, int length) throws SAXException {
    tmpElementValue = new String (
        ch, 
        start, 
        length
    );
}


public void characters (char ch [], int start, int length) throws SAXException {
     tmpElementValue = Arrays.copyOfRange(
        ch, 
        start, 
        start+length
    );
}


