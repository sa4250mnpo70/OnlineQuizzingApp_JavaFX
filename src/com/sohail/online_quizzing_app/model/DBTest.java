/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author sohail.alam
 */
public class DBTest {

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection("localhost", "root", "root", "OnlineQuizzingApp");
        DBQuery dbQuery = new DBQuery();
        Connection connection = null;
        try {
            connection = dbConnection.DBConnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DBQuery query = new DBQuery(connection, "localhost", "root", "root", "OnlineQuizzingApp");
        try {
            ResultSet result = query.DBReadDatabase("OnlineQuizzingApp");
            int count = 0;
            result.beforeFirst(); // Move to just before the first element
            while (result.next()) { // Iterate and fill the string array
                System.out.println(result.getString(result.getMetaData().getColumnLabel(count + 1)));
                count++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
