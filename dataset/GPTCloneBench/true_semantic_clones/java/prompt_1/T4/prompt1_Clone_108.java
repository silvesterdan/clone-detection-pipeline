public void actionPerformed (ActionEvent e) {
    String item = (String) mainComboBox.getSelectedItem ();
    Object o = subItems.get (item);
    if (o == null) {
        subComboBox.setModel (new DefaultComboBoxModel ());
    } else {
        subComboBox.setModel (new DefaultComboBoxModel ((String []) o));
    }
}


public void actionPerformed (ActionEvent e) {
    String item = (String) mainComboBox.getSelectedItem ();
    Object o = subItems.get (item);
    DefaultComboBoxModel subCbModel = new DefaultComboBoxModel ();
    if (o == null) {
        subCbModel.addElement("");
    } else {
        for (String oObj : o){
            subCbModel.addElement(oObj);
        }

    }
    subComboBox.setModel (subCbModel);
}


