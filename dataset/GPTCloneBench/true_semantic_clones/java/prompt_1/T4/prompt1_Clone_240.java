public static void main (String [] args) {
    Integer n = Integer.parseInt (args [0]);
    Queue < Integer > q = new Queue < Integer > ();
    while (! StdIn.isEmpty ()) {
        q.enqueue (StdIn.readInt ());
    }
    while (q.size () > n) {
        q.dequeue ();
    }
    StdOut.println (q.peek ().toString ());
}


public static void main (String [] args) {
    int n = Integer.parseInt (args [0]);
    ArrayDeque < Integer > q = new ArrayDeque < Integer > ();
    while (System.in.available () > 0) {
        q.addLast (System.in.read ());
    }
    while (q.size () > n) {
        q.removeFirst ();
    }
    System.out.println (q.peekFirst ().toString ());
}


