        public void run () {
            WhiteSpace ws = new WhiteSpace ();
            Container gui = ws.getGui ();
            JFrame f = new JFrame ("White (OK Red) Space");
            f.add (gui);
            f.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform (true);
            f.setResizable (false);
            f.pack ();
            f.setVisible (true);
}


          public void run () {
                WhiteSpace ws = new WhiteSpace();
                Container gui = ws.getGui();
                JFrame f = new JFrame("White (OK Red) Space");
                f.add(gui);
                f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                f.setLocationByPlatform (true);
                f.setSize(800,800);
                f.setResizable (false);
                f.setVisible (true);
}
