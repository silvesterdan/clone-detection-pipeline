public void characters (char ch [], int start, int length) throws SAXException {
    tmpElementValue = new String (
        ch, 
        start, 
        length
    );
}


public void characters (char ch [], int start, int length) throws SAXException {
     char[] tmpChars = new char[length];
     System.arraycopy(ch, 
     start, tmpChars, 0, 
     length);
     tmpElementValue = new String(tmpChars);
}


