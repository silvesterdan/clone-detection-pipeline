        public void changed (ObservableValue < ? extends Bounds > observable, Bounds oldValue, Bounds newValue) {
            if (oldHeight != newValue.getHeight ()) {
                System.out.println ("newValue = " + newValue.getHeight ());
                oldHeight = newValue.getHeight ();
                textArea.setPrefHeight (textHolder.getLayoutBounds ().getHeight () + 20);
            }
}


  public void changed (ObservableValue < ? extends Bounds > observable, Bounds oldValue, Bounds newValue) {if (oldHeight != newValue.getHeight()) {
      System.out.println("newValue = " + newValue.getHeight());
      oldHeight = newValue.getHeight();
      textArea.setPrefHeight(Math.max(textArea.getPrefHeight(), textHolder.getLayoutBounds().getHeight() + 20));
   }
}
