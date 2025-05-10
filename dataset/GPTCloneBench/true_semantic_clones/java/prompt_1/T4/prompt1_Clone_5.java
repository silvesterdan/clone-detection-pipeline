public Node reverse (Node previous, Node current) {
    if (previous == null) return null;
    if (previous.equals (head)) previous.setNext (null);
    if (current == null) {
        head = previous;
        return head;
    } else {
        Node temp = current.getNext ();
        current.setNext (previous);
        reverse (current, temp);
    }
    return null;
}


public Node reverse(Node previous, Node current){ 
    if (previous == null) return null; 
    if (previous.equals(head)) {
        previous.setNext (null);
    }
    while(current != null) {
        Node temp = current.getNext(); 
        current.setNext (previous); 
        previous = current;
        current = temp;
    }
    head = previous; 
    return head;
}


