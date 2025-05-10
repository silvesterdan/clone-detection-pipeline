public void actionPerformed (ActionEvent e) {
    String name = employeeName.getText ();
    if (name.equals ("") || alreadyInList (name)) {
        Toolkit.getDefaultToolkit ().beep ();
        employeeName.requestFocusInWindow ();
        employeeName.selectAll ();
        return;
    }
    int index = list.getSelectedIndex ();
    if (index == - 1) {
        index = 0;
    } else {
        index ++;
    }
    listModel.insertElementAt (employeeName.getText (), index);
    employeeName.requestFocusInWindow ();
    employeeName.setText ("");
    list.setSelectedIndex (index);
    list.ensureIndexIsVisible (index);
}


public void actionPerformed (ActionEvent e) {
    String name = employeeName.getText ();
    if (!"".equals (name) && !alreadyInList (name)) {
        int index = list.getSelectedIndex ();
        index = (index == -1) ? 0 : ++index;
        listModel.insertElementAt (name, index);
        employeeName.requestFocusInWindow ();
        employeeName.setText ("");
        list.setSelectedIndex (index);
        list.ensureIndexIsVisible (index);

    } else {
        Toolkit.getDefaultToolkit ().beep ();
        employeeName.requestFocusInWindow ();
        employeeName.selectAll ();
    }
}


