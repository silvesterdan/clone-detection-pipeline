public static void main (String [] args) {
    try {
        InetAddress address = InetAddress.getByName ("192.168.1.103");
        boolean reachable = address.isReachable (10000);
        System.out.println ("Is host reachable? " + reachable);
    } catch (Exception e) {
        e.printStackTrace ();
    }
}


public static void main (String [] args) {
    try {
        InetAddress address = InetAddress.getByName("192.168.2.112");
        boolean reachability = address.isReachable (10000);
        System.out.println("Is host reachable? " + reachability);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
