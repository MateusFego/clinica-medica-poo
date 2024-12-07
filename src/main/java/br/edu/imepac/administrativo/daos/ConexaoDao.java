package br.edu.imepac.administrativo.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/clinica_medica";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Method to get a connection to the database
    public static Connection getConexao() throws SQLException {
        try {
            // Load MySQL JDBC Driver (Not needed for newer JDBC versions but kept for compatibility)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish and return the connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        } catch (SQLException e) {
            throw new SQLException("Unable to connect to the database.", e);
        }
    }

    // Method to close the connection
    public static void closeConexao(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}

