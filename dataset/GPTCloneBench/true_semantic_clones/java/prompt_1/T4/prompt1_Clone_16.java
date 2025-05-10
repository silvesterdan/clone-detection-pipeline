public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
    setToolTipText ("Row " + row + " Column " + column + "\nUsed to display a 'Tip' for a Component. " + "Typically components provide api to automate the process of " + "using ToolTips. For example, any Swing component can use the " + "JComponent  setToolTipText method to specify the text for a standard tooltip.");
    return this;
}


public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
    setToolTipText ("Row " + row + " Column " + column + "\nThis cell is ");
    if (isSelected) 
        setToolTipText(getToolTipText() + " selected. \nUsed to display a 'Tip' for a Component. " + "Typically components provide api to automate the process of " + "using ToolTips. For example, any Swing component can use the " + "JComponent  setToolTipText method to specify the text for a standard tooltip.");
    else 
        setToolTipText(getToolTipText() + " not selected. \nUsed to display a 'Tip' for a Component. " + "Typically components provide api to automate the process of " + "using ToolTips. For example, any Swing component can use the " + "JComponent  setToolTipText method to specify the text for a standard tooltip.");
    return this;
}


