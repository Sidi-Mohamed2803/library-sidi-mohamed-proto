package com.library.library_sidi_mohamed.domainManager;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class DBConnection {

    private static final String URL = "jdbc:oracle:thin:@";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
         
    public static final String USERNAME = "librarySidi";//Change it to yours.
    public static final String PASSWORD = "librarySidi";//Change it to yours.
    
    //The port is the one you used when you created the Tunnel.
    public static final String LOCAL_DEFAULT_CONNECT_DESCRIPTOR = "localhost:1521:ORCL"; 

    private static Connection connection = null;
    private static DBConnection instance = null;

    @SuppressWarnings("deprecation")
	private DBConnection() {
        try {
            Class.forName(DRIVER).newInstance();
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public static DBConnection getInstance() {
        if (connection == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                OracleDataSource ods = new OracleDataSource();
                ods.setURL(URL + LOCAL_DEFAULT_CONNECT_DESCRIPTOR);
                ods.setUser(USERNAME);
                ods.setPassword(PASSWORD);
                connection = ods.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}