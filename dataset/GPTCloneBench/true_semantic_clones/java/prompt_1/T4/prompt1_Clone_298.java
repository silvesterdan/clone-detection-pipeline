public void put (Key key, Value val) {
    if (map.containsKey (key)) {
        put (key, val);
        return;
    }
    while (currentSize >= maxSize) {
        freeSpace ();
    }
    synchronized (this) {
        queue.add (key);
        map.put (key, val);
        currentSize ++;
    }
}


public void put (Key key, Value val) {
    if (map.containsKey (key)) 
        return;
    while (currentSize >= maxSize) 
        freeSpace ();
    synchronized (this) {
        map.remove(key);
        queue.add (key);
        map.put (key, val);
        currentSize ++;
    }

}


