/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.tests;

import com.sohail.online_quizzing_app.BootStrap;
import com.sohail.online_quizzing_app.model.DBConnection;
import com.sohail.online_quizzing_app.model.DBQuery;
import com.sohail.online_quizzing_app.model.DBUsers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author sohail.alam
 */
public class DBTest {

    public static void main(String[] args) {

        //Test 0
        BootStrap.getInstance().Initialize();

        //Test 1
        DBConnection dbConnection = new DBConnection("localhost", "root", "dB@123", "OnlineQuizzingApp");
        DBQuery dbQuery = new DBQuery();
        Connection connection = null;
        try {
            connection = dbConnection.dbConnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DBQuery query = new DBQuery();
        try {
            ResultSet result = query.dbReadDatabase(connection, "OnlineQuizzingApp");
            result.beforeFirst(); // Move to just before the first element
            while (result.next()) { // Iterate and fill the string array
                System.out.println(result.getString(result.getMetaData().getColumnLabel(1)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HashMap<String, String> valuesMap = new HashMap<>();

        valuesMap.put("username", "SohailUsername3");
        valuesMap.put("password", "SohailPassword3");
        valuesMap.put("first_name", "Sohail");
        valuesMap.put("middle_name", "");
        valuesMap.put("last_name", "Alam");
        valuesMap.put("email1", "sohailalam3@hotmail.com");
        valuesMap.put("email2", "");
        valuesMap.put("phone", "");
        valuesMap.put("mobile", "");
        valuesMap.put("address", "");
        valuesMap.put("dob", "1990-10-10");
        valuesMap.put("date_of_joining", "2013-02-11");

        DBUsers users = new DBUsers();

        //TEST 2
        //users.createUser(valuesMap);

        //TEST 2
        //users.createStudent("712676dd-2f9c-4e50-af80-5185f985afae", "Electronics", "460/08");

        //TEST 3
        //users.createAdmin("f09fae47-b662-458d-87ef-44bd3b5a62f5");

        //TEST 4
        System.out.println("VALIDATE USER: " + users.validateUser("SohailUsername2", "SohailPassword2"));
    }
}
