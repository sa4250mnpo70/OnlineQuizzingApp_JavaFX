/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOHAIL
 */
public class BootStrap {
    private static BootStrap instance = new BootStrap();
    
    public static BootStrap getInstance(){
        return instance;
    }

    private Properties DBProperties = new Properties();
    
    private BootStrap(){
        
    }
    
    public void Initialize() {
        //Load the properties file
        File DBPropertiesFile = new File("./resources/DBDetails.properties");
        FileInputStream DBPropertiesFileIS;
        try {
            DBPropertiesFileIS = new FileInputStream(DBPropertiesFile);
        this.DBProperties.load(DBPropertiesFileIS);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    /**
     * @return the DBProperties
     */
    public Properties getDBProperties() {
        return DBProperties;
    }
    
}
