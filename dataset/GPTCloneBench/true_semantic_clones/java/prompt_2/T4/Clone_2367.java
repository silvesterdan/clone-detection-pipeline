private void transform (XSSFWorkbook workbookOld, HSSFWorkbook workbookNew, XSSFRow rowOld, HSSFRow rowNew) {
    HSSFCell cellNew;
    rowNew.setHeight (rowOld.getHeight ());
    for (Cell cell : rowOld) {
        cellNew = rowNew.createCell (cell.getColumnIndex (), cell.getCellType ());
        if (cellNew != null) this.transform (workbookOld, workbookNew, (XSSFCell) cell, cellNew);
    }
    this.lastColumn = Math.max (this.lastColumn, rowOld.getLastCellNum ());
}


 private void transform (XSSFWorkbook workbookOld, HSSFWorkbook workbookNew, XSSFRow rowOld, HSSFRow rowNew) {int maxCol = 0; 
    rowNew.setHeight (rowOld.getHeight ()); 
    for (Cell cell : rowOld) {
        HSSFCell cellNew = rowNew.createCell (cell.getColumnIndex (), cell.getCellType ());
        if (cellNew != null)
            this.transform (workbookOld, workbookNew, (XSSFCell) cell, cellNew);        
        maxCol = Math.max (maxCol, cell.getColumnIndex ());
    }
    this.lastColumn = Math.max (this.lastColumn, maxCol);
}


