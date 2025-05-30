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


public static boolean containsLoop (Node root) {
    if (root == null) return false;
    Node slow = root, fast = root;
    int clicked = 0, limit = 2;
    while (fast.next != null) {
        fast = fast.next;
        clicked ++;
        if (slow == fast) return true;
        if (clicked == limit) {
            clicked = 0;
            limit <<= 1;
            slow = fast;
        }
    }
    return false;
}
