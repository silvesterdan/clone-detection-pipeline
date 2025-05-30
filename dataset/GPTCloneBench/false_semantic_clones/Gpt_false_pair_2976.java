private void transform (HSSFWorkbook workbookOld, XSSFWorkbook workbookNew, HSSFCell cellOld, XSSFCell cellNew) {
    cellNew.setCellComment (cellOld.getCellComment ());
    Integer hash = cellOld.getCellStyle ().hashCode ();
    if (this.styleMap != null && ! this.styleMap.containsKey (hash)) {
        this.transform (workbookOld, workbookNew, hash, cellOld.getCellStyle (), (XSSFCellStyle) workbookNew.createCellStyle ());
    }
    cellNew.setCellStyle (this.styleMap.get (hash));
    switch (cellOld.getCellType ()) {
        case Cell.CELL_TYPE_BLANK :
            break;
        case Cell.CELL_TYPE_BOOLEAN :
            cellNew.setCellValue (cellOld.getBooleanCellValue ());
            break;
        case Cell.CELL_TYPE_ERROR :
            cellNew.setCellValue (cellOld.getErrorCellValue ());
            break;
        case Cell.CELL_TYPE_FORMULA :
            cellNew.setCellValue (cellOld.getCellFormula ());
            break;
        case Cell.CELL_TYPE_NUMERIC :
            cellNew.setCellValue (cellOld.getNumericCellValue ());
            break;
        case Cell.CELL_TYPE_STRING :
            cellNew.setCellValue (cellOld.getStringCellValue ());
            break;
        default :
            System.out.println ("transform: Unbekannter Zellentyp " + cellOld.getCellType ());
    }
}


 private void transform(HSSFWorkbook workbookOld, XSSFWorkbook workbookNew, HSSFCell cellOld, XSSFCell cellNew) {
    cellNew.setCellComment(cellOld.getCellComment());
    Integer hash = cellOld.getCellStyle().hashCode();
    if (this.styleMap != null && !this.styleMap.containsKey(hash)) {
        this.transform(workbookOld, workbookNew, hash, cellOld.getCellStyle(), (XSSFCellStyle) workbookNew.createCellStyle());
    }
    cellNew.setCellStyle(this.styleMap.get(hash));
    switch (cellOld.getCellType()) {
        case Cell.CELL_TYPE_BLANK:
            break;
        case Cell.CELL_TYPE_BOOLEAN:
            if (cellOld.getBooleanCellValue()) {
                cellNew.setCellValue("TRUE");
            } else {
                cellNew.setCellValue("FALSE");
            }
            break;
        case Cell.CELL_TYPE_ERROR:
            cellNew.setCellValue(cellOld.getErrorCellValue());
            break;
        case Cell.CELL_TYPE_FORMULA:
            cellNew.setCellValue(cellOld.getCellFormula());
            break;
        case Cell.CELL_TYPE_NUMERIC:
            cellNew.setCellValue(cellOld.getNumericCellValue());
            break;
        case Cell.CELL_TYPE_STRING:
            cellNew.setCellValue(cellOld.getStringCellValue());
            break;
        default:
            System.out.println("transform: Unbekannter Zellentyp " + cellOld.getCellType());
    }
	if (cellOld.getCellType() == Cell.CELL_TYPE_BLANK) {
		cellNew.setCellValue("No content. Please fill in");
	}
}
