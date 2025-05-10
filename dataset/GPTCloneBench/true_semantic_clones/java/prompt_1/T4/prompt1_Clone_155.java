public void actionPerformed (ActionEvent arg0) {
    if (! dirty) {
        JFileChooser ch = getFileChooser ();
        int result = ch.showOpenDialog (gui);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage bi = ImageIO.read (ch.getSelectedFile ());
                setImage (bi);
            } catch (IOException e) {
                showError (e);
                e.printStackTrace ();
            }
        }
    } else {
        JOptionPane.showMessageDialog (gui, "TODO - prompt save image..");
    }
}


public void actionPerformed (ActionEvent arg0) {
    if (! dirty) {
        InputStream stream = new FileInputStream(new File("image.jpg"));
        BufferedImage bi = ImageIO.read (stream);
        setImage (bi);
    } else {
        JOptionPane.showMessageDialog (gui, "TODO - prompt save image..");
    }
}


