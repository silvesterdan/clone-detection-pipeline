public void characters (char ch [], int start, int length) throws SAXException {
    tmpElementValue = new String (
        ch, 
        start, 
        length
    );
}


public void characters (char ch [], int start, int length) throws SAXException {
     StringBuilder sb = new StringBuilder();
     sb.append(ch,
     start,
     length);
     tmpElementValue = sb.toString();
}


