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

    public DBQuery() {
    }

    public ResultSet DBExecuteQuery(Connection connection, String str_query) throws Exception {

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

    public int DBExecuteUpdate(Connection connection, String str_query) throws Exception {

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

    public int DBCreateDatabse(Connection connection, String str_databaseName) throws Exception {

        String str_query = null;
        if (connection.isValid(30)) {
            str_query = "CREATE DATABASE " + str_databaseName;
            try {
                return DBExecuteUpdate(connection, str_query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }

    }

    public int DBCreateTable(Connection connection, String str_databaseName, String str_tableName, String str_tableQuery) throws Exception {

        String str_Query = "CREATE TABLE " + str_databaseName + "." + str_tableName + str_tableQuery;
        if (connection.isValid(30)) {
            try {
                return DBExecuteUpdate(connection, str_Query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }

    }

    public ResultSet DBReadDatabase(Connection connection, String str_databaseName) throws Exception {

        String str_query = null;
        ResultSet resultSet = null;
        if (connection.isValid(30)) {
            str_query = "SHOW TABLES FROM " + str_databaseName;
            try {
                resultSet = DBExecuteQuery(connection, str_query);
                return resultSet;
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }

    public ResultSet DBReadTable(Connection connection, String str_databaseName, String str_tableName, String str_readQuery) throws Exception {

        String str_query = null;
        ResultSet resultSet = null;
        if (connection.isValid(30)) {
            if (str_readQuery == null) {
                str_query = "SELECT * FROM " + str_databaseName + "." + str_tableName;
            } else {
                str_query = str_readQuery;
            }
            try {
                resultSet = DBExecuteQuery(connection, str_query);

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

    public int DBDeleteDatabase(Connection connection, String str_databaseName) throws Exception {

        String str_query = "DROP DATABASE " + str_databaseName;
        if (connection.isValid(30)) {
            try {
                return DBExecuteUpdate(connection, str_query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }

    public int DBDeleteTable(Connection connection, String str_databaseName, String str_tableName) throws Exception {

        String str_Query = "DROP TABLE " + str_databaseName + "." + str_tableName;
        if (connection.isValid(30)) {
            try {
                return DBExecuteUpdate(connection, str_Query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }

    public int DBDeleteTableRow(Connection connection, String str_databaseName, String str_tableName, String str_where, String str_whereValue) throws Exception {

        String str_Query = "DELETE FROM " + str_databaseName + "." + str_tableName + " WHERE " + str_where + " = " + str_whereValue;
        if (connection.isValid(30)) {
            try {
                return DBExecuteUpdate(connection, str_Query);
            } catch (Exception e) {
                throw e;
            }
        } else {
            throw new Exception("Database Connection is closed!");
        }
    }
}
