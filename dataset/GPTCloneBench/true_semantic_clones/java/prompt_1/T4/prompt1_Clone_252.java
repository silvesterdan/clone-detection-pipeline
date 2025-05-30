public void dispatchEvent (Event event) {
    checkNotNull (event);
    CancellableEvent cancellableEvent = null;
    boolean cancellable;
    if (cancellable = event instanceof CancellableEvent) {
        cancellableEvent = (CancellableEvent) event;
        checkArgument (cancellableEvent.isCancelled ());
    }
    fireEvents (false, event, cancellableEvent, cancellable);
    fireEvents (true, event, cancellableEvent, cancellable);
}


public void dispatchEvent (Event event) {
    checkNotNull (event);
    CancellableEvent cancellableEvent;
    boolean cancellable;
    if (event instanceof CancellableEvent) {
        cancellableEvent = (CancellableEvent) event;
        cancellable = true;
    } else {
        cancellableEvent = null;
        cancellable = false;
    }
    fireEvents (false, event, cancellableEvent, cancellable);
    fireEvents (true, event, cancellableEvent, cancellable);
}


