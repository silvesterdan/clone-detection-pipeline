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
    boolean isLocked = lock.tryLock();
    try {
        if (isLocked) {
            Item < VV > item = cache.remove (key);
            if (item != null) {
                return item.payload;
            }
        }
    } finally {
        if (isLocked) {
            lock.unlock();
        }
    }
    return null;
}


