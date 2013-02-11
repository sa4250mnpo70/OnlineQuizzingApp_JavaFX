/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sohail.alam
 */
public class DBQuery {

    private static String db_url = null;
    private static String db_username = null;
    private static String db_password = null;
    private static String database_name = null;
    private static Connection connection = null;
    
    public DBQuery() {
    }

    public DBQuery(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String DATABASE_NAME){
        DBQuery.connection = connection;
        DBQuery.db_url = DB_URL;
        DBQuery.db_username = DB_USERNAME;
        DBQuery.db_password = DB_PASSWORD;
        DBQuery.database_name = DATABASE_NAME;
    }
    
    public ResultSet DBExecuteQuery(String str_query) throws Exception{
        return DBExecuteQuery(connection, db_url, db_username, db_password, database_name, str_query);
    }
    
    /**
     * This method is used to execute a given SQL Query
     *
     * @param connection
     * @param DB_URL
     * @param DB_USERNAME
     * @param DB_PASSWORD
     * @param str_databaseName
     * @param str_query
     * @return
     * @throws Exception
     */
    public ResultSet DBExecuteQuery(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName, String str_query) throws Exception {

        Statement statement = null;
        if (connection.isValid(30)) {
            try {
                // Execute a query
                statement = connection.createStatement();
                return statement.executeQuery(str_query);
            } catch (SQLException e) {
                // Handle errors for JDBC
                throw e;
            } catch (Exception ex) {
                // Handle errors for Class.forName
                throw ex;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }

    public int DBExecuteUpdate(String str_query) throws Exception{
        return DBExecuteUpdate(connection, db_url, db_username, db_password, database_name, str_query);
    }
    
    /**
     *
     * @param connection
     * @param DB_URL
     * @param DB_USERNAME
     * @param DB_PASSWORD
     * @param str_databaseName
     * @param str_query
     * @return
     * @throws Exception
     */
    public int DBExecuteUpdate(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName, String str_query) throws Exception {

        Statement statement = null;
        if (connection.isValid(30)) {
            try {
                // Execute a query
                statement = connection.createStatement();
                return statement.executeUpdate(str_query);
            } catch (SQLException e) {
                // Handle errors for JDBC
                throw e;
            } catch (Exception ex) {
                // Handle errors for Class.forName
                throw ex;
            }
        } else {
            throw new Exception("Database Connection is Closed!");
        }
    }

    public int DBCreateDatabse(String str_databaseName) throws Exception {
        return DBCreateDatabse(connection, db_url, db_username, db_password, str_databaseName);
    }
    
    /**
     *
     * @param connection
     * @param DB_URL
     * @param DB_USERNAME
     * @param DB_PASSWORD
     * @param str_databaseName
     * @return
     * @throws Exception
     */
    public int DBCreateDatabse(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName) throws Exception {

        String str_query = null;
        if (connection.isValid(30)) {
            str_query = "CREATE DATABASE " + str_databaseName;
            try {
                return DBExecuteUpdate(connection, DB_URL, DB_USERNAME, DB_PASSWORD, null, str_query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }

    }

    public int DBCreateTable(String str_databaseName, String str_tableName, String str_tableQuery) throws Exception {
        return DBCreateTable(connection, db_url, db_username, db_password, str_databaseName, str_tableName, str_tableQuery);
    }
    
    /**
     *
     * @param connection
     * @param DB_URL
     * @param DB_USERNAME
     * @param DB_PASSWORD
     * @param str_databaseName
     * @param str_tableName
     * @param str_tableQuery
     * @return
     * @throws Exception
     */
    public int DBCreateTable(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName, String str_tableName, String str_tableQuery) throws Exception {

        String str_Query = "CREATE TABLE " + str_databaseName + "." + str_tableName + str_tableQuery;
        if (connection.isValid(30)) {
            try {
                return DBExecuteUpdate(connection, DB_URL, DB_USERNAME, DB_PASSWORD, str_databaseName, str_Query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }

    }
    
    public ResultSet DBReadDatabase(String str_databaseName) throws Exception {
        return DBReadDatabase(connection, db_url, db_username, db_password, str_databaseName);
    }

    /**
     *
     * @param connection
     * @param DB_URL
     * @param DB_USERNAME
     * @param DB_PASSWORD
     * @param str_databaseName
     * @return
     * @throws Exception
     */
    public ResultSet DBReadDatabase(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName) throws Exception {

        String str_query = null;
        ResultSet resultSet = null;
        if (connection.isValid(30)) {
            str_query = "SHOW TABLES";
            try {
                resultSet = DBExecuteQuery(connection, DB_URL, DB_USERNAME, DB_PASSWORD, str_databaseName, str_query);
                return resultSet;
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }
    
    public ResultSet DBReadTable(String str_databaseName, String str_tableName, String str_readQuery) throws Exception {
        return DBReadTable(connection, db_url, db_username, db_password, str_databaseName, str_tableName, str_readQuery);
    }

    /**
     *
     * @param connection
     * @param DB_URL
     * @param DB_USERNAME
     * @param DB_PASSWORD
     * @param str_databaseName
     * @param str_tableName
     * @param str_readQuery
     * @return
     * @throws Exception
     */
    public ResultSet DBReadTable(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName, String str_tableName, String str_readQuery) throws Exception {

        String str_query = null;
        ResultSet resultSet = null;
        if (connection.isValid(30)) {
            if (str_readQuery == null) {
                str_query = "SELECT * FROM " + str_tableName;
            } else {
                str_query = str_readQuery;
            }
            try {
                resultSet = DBExecuteQuery(connection, DB_URL, DB_USERNAME, DB_PASSWORD,
                        str_databaseName, str_query);

                resultSet.beforeFirst();
                if (resultSet.next()) {
                    return resultSet;
                } else {
                    resultSet.close();
                    throw new Exception("Resultset is Closed!");
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }

    public int DBDeleteDatabase(String str_databaseName) throws Exception {
        return DBDeleteDatabase(connection, db_url, db_username, db_password, str_databaseName);
    }
    
    /**
     *
     * @param connection
     * @param DB_URL
     * @param DB_USERNAME
     * @param DB_PASSWORD
     * @param str_databaseName
     * @return
     * @throws Exception
     */
    public int DBDeleteDatabase(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName) throws Exception {

        String str_query = "DROP DATABASE " + str_databaseName;
        if (connection.isValid(30)) {
            try {
                return DBExecuteUpdate(connection, DB_URL, DB_USERNAME, DB_PASSWORD, str_databaseName, str_query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }

    public int DBDeleteTable(String str_databaseName, String str_tableName) throws Exception {
        return DBDeleteTable(connection, db_url, db_username, db_password, str_databaseName, str_tableName);
    }
    
    /**
     *
     * @param connection
     * @param DB_URL
     * @param DB_USERNAME
     * @param DB_PASSWORD
     * @param str_databaseName
     * @param str_tableName
     * @return
     * @throws Exception
     */
    public int DBDeleteTable(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName, String str_tableName) throws Exception {

        String str_Query = "DROP TABLE " + str_tableName;
        if (connection.isValid(30)) {
            try {
                return DBExecuteUpdate(connection, DB_URL, DB_USERNAME, DB_PASSWORD, str_databaseName, str_Query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }

    public int DBDeleteTableRow(String str_databaseName, String str_tableName, String str_where, String str_whereValue) throws Exception {
        return DBDeleteTableRow(connection, db_url, db_username, db_password, str_databaseName, str_tableName, str_where, str_whereValue);
    }
    
    /**
     *
     * @param connection
     * @param DB_URL
     * @param DB_USERNAME
     * @param DB_PASSWORD
     * @param str_databaseName
     * @param str_tableName
     * @param str_where
     * @param str_whereValue
     * @return
     * @throws Exception
     */
    public int DBDeleteTableRow(Connection connection, String DB_URL, String DB_USERNAME, String DB_PASSWORD, String str_databaseName, String str_tableName, String str_where, String str_whereValue) throws Exception {

        String str_Query = "DELETE FROM " + str_databaseName + "." + str_tableName + " WHERE " + str_where + " = " + str_whereValue;
        if (connection.isValid(30)) {
            try {
                return DBExecuteUpdate(connection, DB_URL, DB_USERNAME, DB_PASSWORD, str_databaseName, str_Query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }
}
