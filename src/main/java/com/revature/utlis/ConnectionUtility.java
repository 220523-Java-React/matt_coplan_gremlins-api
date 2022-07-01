package com.revature.utlis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

    //create private constructor
    private ConnectionUtility(){}

    //create instance of connection
    public static Connection instance;

    // Create String values for database ( should be in properties file!)
    static final String url = "jdbc:postgresql://localhost:5432/postgres?CurrentSchema=public";
    static final String username = "postgres";
    static final String password = "password";

    // propagate exception
    public static Connection getInstance() throws SQLException {

        // check if instance is null or closed before opening
        if (instance == null || instance.isClosed() ) {
            instance = DriverManager.getConnection(url, username, password);
        }
        return instance;
    }
}
