package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionManager {

    /**
     * 
     */
    private static final String DATABASE_URL = "jdbc:sqlite:src/main/resources/database/persons.db";
    public static final Logger LOGGER = Logger.getLogger(ConnectionManager.class.getName());

    private static Connection connection;

    private ConnectionManager() {

    }

    /**
     * @return
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = createConnection(DATABASE_URL);
        }
        return connection;
    }

    /**
     * @param dbConnection
     * @return
     */
    private static Connection createConnection(String dbConnection) throws SQLException {
        Connection connection = null;
        try { 
            connection = DriverManager.getConnection(DATABASE_URL);
            LOGGER.info(String.format("Conexão com o SQL Lite estabelecida. %s", connection.getCatalog()));
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
            throw e;
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (getConnection() != null) {
            getConnection().close();
        }
    }
}
