public void itemStateChanged (ItemEvent e) {
    size = Integer.parseInt ((String) box.getSelectedItem ());
    if (e.getStateChange () == ItemEvent.SELECTED) {
        for (i = 1; i <= size; i ++) {
            System.out.print (" " + i);
        }
        System.out.println ();
    }
}


	public void itemStateChanged (ItemEvent e) {
    size = Integer.parseInt ((String) box.getSelectedItem ());
    if (e.getStateChange () == ItemEvent.SELECTED) {
        for (int i = 0; i < size; i++) {
            System.out.print((i+1) + " ");
            for (int j = i + 1; j < size; j++) {
            System.out.print((j+1) + " ");
            }
           System.out.println();
        }
    }
}


