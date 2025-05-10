public VV remove (String key) {
    synchronized (lock) {
        Item < VV > item = cache.remove (key);
        if (item != null) {
            return item.payload;
        } else {
            return null;
        }
    }
}


public VV remove (String key) {
    lock.lock();
    Item < VV > item = cache.remove (key);
    if (item != null) {
        VV payload = item.payload;
        lock.unlock();
        return payload;
    }
    lock.unlock();
    return null;
}


