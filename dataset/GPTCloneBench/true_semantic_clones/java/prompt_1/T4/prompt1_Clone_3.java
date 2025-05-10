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


public Node reverse (Node previous, Node current) {
   if (previous == null) {
        return null;
    } else if (previous.equals (head)) {
        previous.setNext (null); 
    }
   
    // Conditionals inverted
    if (current != null) {
        Node temp = current.getNext ();
        current.setNext (previous);
        reverse (current, temp);
    } else {
        head = previous;
        return head;
    }
    return null;
}


