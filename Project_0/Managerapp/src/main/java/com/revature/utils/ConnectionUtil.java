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

            // Define the database URL. Replace "your_database.db" with your database file path.
            // For an in-memory database, use "jdbc:sqlite::memory:"
            String url = "jdbc:sqlite:/Users/andrew/Desktop/Revature/Project_0/my_database.db";

            // Establish the connection
            //connection = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite database established successfully!");

            // You can now perform database operations (create tables, insert, select, etc.)
            // Example: Create a table
            // Statement statement = connection.createStatement();
            // statement.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT)");

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