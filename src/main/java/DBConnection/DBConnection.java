package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A utility class to manage and provide a database connection.
 */
public class DBConnection {

    // Define database connection parameters as constants.
    // It's a good practice to keep them in one place.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/usindh_project";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * A static initializer block.
     * This code runs only once when the class is loaded into memory by the JVM.
     * It's the standard and most efficient way to register a JDBC driver.
     */
    static {
        try {
            // Register the JDBC driver
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            // Use a logger to record the critical error.
            // If the driver isn't found, no connections can be made.
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, "MySQL JDBC Driver not found.", e);
            // Throwing a runtime exception is appropriate here because the application cannot recover.
            throw new RuntimeException("MySQL JDBC Driver not found.", e);
        }
    }

    /**
     * Establishes and returns a connection to the database.
     * This method is static so it can be called directly without creating an instance of DBConnection.
     *
     * @return A Connection object to the database.
     * @throws SQLException if a database access error occurs.
     */
    public static Connection getConnection() throws SQLException {
        // Create the connection using the defined constants
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        
        // This is good for debugging but should ideally be replaced with logging in a production environment.
        System.out.println("Connected to the database successfully!");
        
        // Return the established connection
        return connection;
    }
}