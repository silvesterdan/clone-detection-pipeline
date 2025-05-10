public static void close (Statement...statements) {
    for (Statement stmt : statements) {
        try {
            if (stmt != null) stmt.close ();
        } catch (SQLException se) {
        }
    }
}


public static void close (Statement...statements) {
    for (Statement stmt : statements) {
        try {
            if (stmt != null) {
                if (stmt.isClosed()) {
                    System.out.println("Statement is already closed.");
                    return;
                } else {
                    stmt.close ();
                }
            }
        } catch (SQLException se) {
            System.err.println(se);
        }
    }
}


