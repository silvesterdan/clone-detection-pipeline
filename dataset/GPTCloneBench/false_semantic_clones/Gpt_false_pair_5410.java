public void changed (ObservableValue < ? extends Bounds > observable, Bounds oldValue, Bounds newValue) {
    if (oldHeight != newValue.getHeight ()) {
        System.out.println ("newValue = " + newValue.getHeight ());
        oldHeight = newValue.getHeight ();
        textArea.setPrefHeight (textHolder.getLayoutBounds ().getHeight () + 20);
    }
}


public void changed (ObservableValue < ? extends Bounds > observable, Bounds oldValue, Bounds newValue) {
    if (oldArea != newValue.getArea ()) {
        System.out.println ("newValue = " + newValue.getArea ());
        oldArea = newValue.getArea ();
        textArea.setPrefArea (textHolder.getLayoutBounds ().getArea () + 20);
    }
}
