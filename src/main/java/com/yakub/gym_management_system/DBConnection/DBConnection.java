package com.yakub.gym_management_system.DBConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String SQLITECONN ="jdbc:sqlite:src/main/resources/gym_db.sqlite";

    public boolean isDBConnected() throws SQLException {
        return DBConnection.getConnection() != null;
    }

    public static Connection getConnection() throws SQLException {

       try {
           Class.forName("org.sqlite.JDBC");
           return DriverManager.getConnection(SQLITECONN);
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
           return null;

       }

    }

}
