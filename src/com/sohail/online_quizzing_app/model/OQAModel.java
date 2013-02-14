/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model;

import com.sohail.online_quizzing_app.BootStrap;
import java.util.Properties;
import org.javalite.activejdbc.*;

/**
 *
 * @author sohail.alam
 */
public class OQAModel {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // JDBC driver name
    private static final String JDBC_URL = "jdbc:mysql://"; // JDBC URL

    public void dbConnect() {
        Properties db_prop = BootStrap.getInstance().getDBProperties();
        String db_url = JDBC_URL + db_prop.getProperty("URL");
        String db_username = db_prop.getProperty("Username");
        String db_password = db_prop.getProperty("Password");
        Base.open(JDBC_DRIVER, db_url, db_username, db_password);
    }
}
