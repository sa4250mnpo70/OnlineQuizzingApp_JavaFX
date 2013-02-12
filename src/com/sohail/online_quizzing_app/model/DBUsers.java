/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sohail.online_quizzing_app.BootStrap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;

/**
 *
 * @author SOHAIL
 */
public class DBUsers {

    private final Properties DBProperties;
    private final String DBURL;
    private final String DBUsername;
    private final String DBPassword;
    private final String DBDatabaseName;
    private final String DBTableUsers;
    private final String DBTableAdmin;
    private final String DBTableQuiz;
    private final String DBTableStudents;
    private final String DBTableQuestions;
    private final String DBTableOptions;
    private final String DBTableSolved;
    private final String DBTableSubmittedAnswers;

    public DBUsers() {
        //Initialize all variables containing the details of the database
        DBProperties = BootStrap.getInstance().getDBProperties();
        DBURL = DBProperties.getProperty("URL");
        DBUsername = DBProperties.getProperty("Username");
        DBPassword = DBProperties.getProperty("Password");
        DBDatabaseName = DBProperties.getProperty("DatabaseName");
        DBTableUsers = DBProperties.getProperty("TableUsers");
        DBTableAdmin = DBProperties.getProperty("TableAdmin");
        DBTableStudents = DBProperties.getProperty("TableStudents");
        DBTableQuiz = DBProperties.getProperty("TableQuiz");
        DBTableQuestions = DBProperties.getProperty("TableQuestions");
        DBTableOptions = DBProperties.getProperty("TableOptions");
        DBTableSolved = DBProperties.getProperty("TableQuizSolved");
        DBTableSubmittedAnswers = DBProperties.getProperty("TableSubmittedAnswers");
    }

    public String ValidateUser(String username, String password) {
        String uuid = null;
        String match_student_uuid = null;
        String match_admin_uuid = null;

        String query = "SELECT uuid FROM " + DBTableUsers
                + " WHERE username = '" + username
                + "' AND password = '" + password + "'";

        DBConnection DBCon = new DBConnection(DBURL, DBUsername, DBPassword, DBDatabaseName);
        Connection connection1 = null;
        Connection connection2 = null;
        Connection connection3 = null;
        DBQuery dBQuery1 = null;
        DBQuery dBQuery2 = null;
        DBQuery dBQuery3 = null;
        ResultSet result = null;
        try {
            connection1 = DBCon.DBConnect();
            connection2 = DBCon.DBConnect();
            connection3 = DBCon.DBConnect();
            dBQuery1 = new DBQuery();
            dBQuery2 = new DBQuery();
            dBQuery3 = new DBQuery();
            result = dBQuery1.DBReadTable(connection1, DBDatabaseName, DBTableUsers, query);
            uuid = result.getString("uuid");
            //Check for Student
            match_student_uuid = "SELECT id FROM " + DBTableStudents
                    + " WHERE uuid_user = '" + uuid + "'";
            result = dBQuery2.DBReadTable(connection2, DBDatabaseName, DBTableStudents, match_student_uuid);
            if (result.getFetchSize() != 0) {
                return "STUDENT";
            } else {
                //Check for Admin User
                match_admin_uuid = "SELECT id FROM " + DBTableAdmin
                        + " WHERE uuid_user = '" + uuid + "'";
                result = dBQuery3.DBReadTable(connection3, DBDatabaseName, DBTableAdmin, match_admin_uuid);
                if (result.getFetchSize() != 0) {
                    return "ADMIN";
                } else {
                    return "UNAUTHORISED";
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return ex.getMessage();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }

    public void CreateUser(HashMap<String, String> valuesMap) {

        String query = "INSERT INTO  " + DBDatabaseName + "." + DBTableUsers
                + "( uuid , username , password , first_name , middle_name , last_name , email1 , email2 , phone , mobile , address , dob , date_of_joining ) VALUES ( '"
                + UUID.randomUUID().toString() + "', '"
                + valuesMap.get("username") + "', '"
                + valuesMap.get("password") + "', '"
                + valuesMap.get("first_name") + "', '"
                + valuesMap.get("middle_name") + "', '"
                + valuesMap.get("last_name") + "', '"
                + valuesMap.get("email1") + "', '"
                + valuesMap.get("email2") + "', '"
                + valuesMap.get("phone") + "', '"
                + valuesMap.get("mobile") + "', '"
                + valuesMap.get("address") + "', '"
                + valuesMap.get("dob") + "', '"
                + valuesMap.get("date_of_joining")
                + "'  )";

        int result = ExecuteUpdate(query);

        //TEST
        System.out.println("QUERY ADD USER: \n" + query);
        System.out.println("QUERY ADD USER RESULT: " + result);
    }

    public void CreateStudent(String uuid_user, String branch, String roll_number) {
        //Query Example
        /*
         INSERT INTO  `onlinequizzingapp`.`students` ( `id` , `uuid_user` , `branch` , `roll_number` ) VALUES ( NULL ,  '12345-12345',  'Electronics',  '460/08' );
         */
        String query = "INSERT INTO  " + DBDatabaseName + "." + DBTableStudents
                + "( uuid_user , branch , roll_number ) VALUES ( '"
                + uuid_user + "', '"
                + branch + "', '"
                + roll_number
                + "'  )";

        int result = ExecuteUpdate(query);

        //TEST
        System.out.println("QUERY ADD STUDENT: \n" + query);

    }

    public void CreateAdmin(String uuid_user) {
        //Query Example
        /*
         INSERT INTO  `onlinequizzingapp`.`admin` ( `uuid_user` ) VALUES ( '12345-12345' );
         */

        String query = "INSERT INTO  " + DBDatabaseName + "." + DBTableAdmin
                + "( uuid_user ) VALUES ( '"
                + uuid_user
                + "'  )";

        int result = ExecuteUpdate(query);

        //TEST
        System.out.println("QUERY ADD ADMIN: \n" + query);
    }

    public void ReadUser() {
    }

    public void ReadStudent() {
    }

    public void ReadAdmin() {
    }

    public void UpdateUser() {
    }

    public void UpdateStudent() {
    }

    public void UpdateAdmin() {
    }

    public void DeleteUser() {
    }

    public void DeleteStudent() {
    }

    public void DeleteAdmin() {
    }

    private int ExecuteUpdate(String query) {
        DBConnection DBCon = new DBConnection(DBURL, DBUsername, DBPassword, DBDatabaseName);
        Connection connection = null;
        DBQuery dBQuery = null;
        int result = 0;
        try {
            connection = DBCon.DBConnect();
            dBQuery = new DBQuery();
            result = dBQuery.DBExecuteUpdate(connection, query);
        } catch (MySQLIntegrityConstraintViolationException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
