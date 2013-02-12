/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sohail.alam
 */
public class DBConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // JDBC driver name
    private static final String JDBC_URL = "jdbc:mysql://"; // JDBC URL
    private static String db_url = null;
    private static String db_username = null;
    private static String db_password = null;
    private static String database_name = null;

    public DBConnection() {
    }

    public DBConnection(String db_url, String db_username, String db_password, String database_name) {
        DBConnection.db_url = db_url;
        DBConnection.db_username = db_username;
        DBConnection.db_password = db_password;
        DBConnection.database_name = database_name;
    }

    public Connection DBConnect() throws Exception {
        return DBConnect(db_url, db_username, db_password, database_name);
    }

    public Connection DBConnect(String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName) throws Exception {

        String DatabaseURL = null;
        Connection connection = null;

        DatabaseURL = DBConnection.JDBC_URL + DB_URL + "/" + str_databaseName;

        try {
            // Register JDBC driver
            Class.forName(DBConnection.JDBC_DRIVER).newInstance();
            // Open a connection
            connection = DriverManager.getConnection(DatabaseURL, DB_USERNAME, DB_PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw e;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public boolean DBDisConnect(Connection connection) throws Exception {
        try {
            if (connection != null) {
                connection.close();
            }
            return true;
        } catch (SQLException exception) {
            throw exception;
        }
    }
}
