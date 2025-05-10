private XSSFFont transform (XSSFWorkbook workbookNew, HSSFFont fontOld) {
    XSSFFont fontNew = workbookNew.createFont ();
    fontNew.setBoldweight (fontOld.getBoldweight ());
    fontNew.setCharSet (fontOld.getCharSet ());
    fontNew.setColor (fontOld.getColor ());
    fontNew.setFontName (fontOld.getFontName ());
    fontNew.setFontHeight (fontOld.getFontHeight ());
    fontNew.setItalic (fontOld.getItalic ());
    fontNew.setStrikeout (fontOld.getStrikeout ());
    fontNew.setTypeOffset (fontOld.getTypeOffset ());
    fontNew.setUnderline (fontOld.getUnderline ());
    return fontNew;
}


 private XSSFFont transform (XSSFWorkbook workbookNew, HSSFFont fontOld) {
    XSSFFont fontNew = workbookNew.createFont ();
    fontNew.setFontName(fontOld.getFontName());
    fontNew.setFontHeight((short) fontOld.getFontHeight());
    fontNew.setBoldweight(fontOld.getBoldweight());
    fontNew.setItalic(fontOld.getItalic());
    fontNew.setTypeOffset(fontOld.getTypeOffset());
    fontNew.setUnderline(fontOld.getUnderline());
    fontNew.setCharSet(fontOld.getCharSet());
    fontNew.setSubscript(fontNew.getTypeOffset()==Font.SS_SUB);
    fontNew.setColor(fontOld.getColor());
    fontNew.setStrikeout(fontOld.getStrikeout());
    return fontNew;
}
