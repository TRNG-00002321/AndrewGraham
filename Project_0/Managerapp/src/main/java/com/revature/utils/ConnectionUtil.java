package com.revature.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    public static Connection dbConnection() {
        Connection connection = null;

        try {
            // Load the SQLite JDBC driver (optional for newer JDBC versions, but good practice)
            //Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/Users/andrew/Desktop/Revature/Project_0/my_database.db");

            String url = "jdbc:sqlite:/Users/andrew/Desktop/Revature/Project_0/my_database.db";


            //System.out.println("Connection to SQLite database established successfully!");


        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                    System.out.println("Connection closed.");
//                }
//            } catch (SQLException e) {
//                System.err.println("Error closing connection: " + e.getMessage());
//            }
//
        }
        return connection;
    }
}