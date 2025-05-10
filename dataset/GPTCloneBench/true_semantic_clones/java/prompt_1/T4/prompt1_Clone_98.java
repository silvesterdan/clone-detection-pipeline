public void actionPerformed (ActionEvent e) {
    try {
        InputStream is = new BufferedInputStream (new FileInputStream (file));
        XMLDecoder xd = new XMLDecoder (is);
        model = (DefaultTableModel) xd.readObject ();
        table.setModel (model);
    } catch (IOException ex) {
        ex.printStackTrace ();
    }
}


public void actionPerformed (ActionEvent e){
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    XMLDecoder xd = null;
    try {
        fis = new FileInputStream(file);
        bis = new BufferedInputStream(fis);
        xd = new XMLDecoder(bis);
        model = (DefaultTableModel) xd.readObject();
        table.setModel (model);
    } catch (IOException ex){
        ex.printStackTrace ();
    } finally {
        try {
            if(fis != null) 
                fis.close();
            if(bis != null) 
                bis.close();
            if(xd != null) 
                xd.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


