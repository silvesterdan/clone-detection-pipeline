private void transform (HSSFWorkbook workbookOld, XSSFWorkbook workbookNew, HSSFRow rowOld, XSSFRow rowNew) {
    XSSFCell cellNew;
    rowNew.setHeight (rowOld.getHeight ());
    for (Cell cell : rowOld) {
        cellNew = rowNew.createCell (cell.getColumnIndex (), cell.getCellType ());
        if (cellNew != null) this.transform (workbookOld, workbookNew, (HSSFCell) cell, cellNew);
    }
    this.lastColumn = Math.max (this.lastColumn, rowOld.getLastCellNum ());
}




private void transform(HSSFWorkbook workbookOld, XSSFWorkbook workbookNew, HSSFRow rowOld, XSSFRow rowNew) {
    rowNew.setHeight(rowOld.getHeight());
    short lastColumn = rowOld.getLastCellNum();
    for (short colIx = 0; colIx < lastColumn; colIx++) {
        XSSFCell cellNew = rowNew.createCell(colIx, rowOld.getCell(colIx).getCellType());
        this.transform(workbookOld, workbookNew, rowOld.getCell(colIx), cellNew);
    }
    this.lastColumn = Math.max(this.lastColumn, lastColumn);
}


