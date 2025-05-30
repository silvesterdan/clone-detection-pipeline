public void insertNodeAfter (E nVal, E curVal) {
    Node < E > prev = findPrevOf (curVal);
    Node < E > curr = null;
    if (prev == null) {
        curr = head;
    } else {
        curr = prev.getNext ();
    }
    Node < E > newNode = new Node < E > (nVal);
    insert (curr, (curr == null ? curr : curr.getNext ()), newNode);
}


public void insertNodeAfter (E nVal, E curVal) {
    Node < E > prev = findPrevOf (curVal);
    Node < E > currNode = null;
    if (prev == null) {
        currNode = head;
    } else {
        currNode = prev.getNext ();
    }
    Node < E > newNode = new Node < E > (nVal);
    insert (prev, currNode, newNode);
}
