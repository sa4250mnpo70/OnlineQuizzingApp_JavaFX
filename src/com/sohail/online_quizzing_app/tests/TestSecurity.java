/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.tests;

import com.sohail.online_quizzing_app.methods.SecurityFeatures;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOHAIL
 */
public class TestSecurity {

    public static void main(String[] args) {
        SecurityFeatures security = new SecurityFeatures();

        byte[] encrypted = null;
        try {
            encrypted = security.Encrypt("AES", "Hello World!", null);
        } catch (Exception ex) {
            Logger.getLogger(TestSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }
        String encrypted_data = new String(encrypted);
        System.out.println("Encrypted Data: " + encrypted_data);
    }
}
