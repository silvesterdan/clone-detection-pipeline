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
    LinkedList < Integer > q = new LinkedList < Integer > ();
    while (System.in.available () > 0) {
        q.add (System.in.read ());
    }
    while (q.size () > n) {
        q.poll ();
    }
    System.out.println (q.peek ().toString ());
}


