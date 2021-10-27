package no.sku.db;

import java.sql.*;

public class DbConnection {

    private final String username = "postgres";
    private final String password = "postgres";
    private final String dbURL = "jdbc:postgresql://localhost:5432/postgres";

    public Connection connect() throws ClassNotFoundException {
        Connection conn = null;
        //Load the driver class
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Unable to load the class. Terminating the program");
            System.exit(-1);
        }

        try {
            conn = DriverManager.getConnection(username, password, dbURL);
            System.out.println("Connected to database...");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return conn;
    }
}