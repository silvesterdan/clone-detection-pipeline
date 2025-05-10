public void contextDestroyed (ServletContextEvent sce) {
    Context initContext = new InitialContext ();
    Context envContext = (Context) initContext.lookup ("java:/comp/env");
    DataSource datasource = (DataSource) envContext.lookup ("jdbc/database");
    try {
        java.sql.Driver mySqlDriver = DriverManager.getDriver ("jdbc:mysql://localhost:3306/");
        DriverManager.deregisterDriver (mySqlDriver);
    } catch (SQLException ex) {
        logger.info ("Could not deregister driver:".concat (ex.getMessage ()));
    }
    dataSource = null;
}



  public void contextDestroyed (ServletContextEvent sce) {
      Context initContext;
      Context envContext;
      DataSource datasource;
      try {
          initContext = new InitialContext ();
          envContext = (Context) initContext.lookup ("java:/comp/env");
          datasource = (DataSource) envContext.lookup("jdbc/database");
          Driver drv = new com.mysql.jdbc.Driver();
          DriverManager.deregisterDriver(drv);
      } catch (NamingException ex) {
           logger.error("NamingException while deregistering driver:".concat(ex.getMessage()), ex);
      } catch (SQLException ex) {
          logger.error("SQL Exception while deregistering driver:".concat(ex.getMessage()), ex);
      } finally {
          datasource = null;
      }
}


