public static boolean hasLoop (Node root) {
    if (root == null) return false;
    Node slow = root, fast = root;
    int taken = 0, limit = 2;
    while (fast.next != null) {
        fast = fast.next;
        taken ++;
        if (slow == fast) return true;
        if (taken == limit) {
            taken = 0;
            limit <<= 1;
            slow = fast;
        }
    }
    return false;
}





public static boolean hasLoop (Node root) {
    if (root == null) return false;
    Node slow = root, fast = root;
    do {
        slow = slow.next;
        fast = fast.next;
        if (fast != null) fast = fast.next;
    } while (slow != null && fast != null && slow != fast);
    return slow == fast;
}


