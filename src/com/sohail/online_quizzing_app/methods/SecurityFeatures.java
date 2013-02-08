/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.methods;

/**
 *
 * @author SOHAIL
 */
public class SecurityFeatures {

    public SecurityFeatures() {
    }

    /**
     * This method uses a cryptographically safe way to hash a given string
     *
     * @param HASH_METHOD
     * @param INPUT
     * @return Hashed String
     */
    public String Hash(final String HASH_METHOD, final String INPUT) {

        String output = null;

        switch (HASH_METHOD) {
            case "SHA-1":

                break;
            case "MD5":

                break;
            default:
                throw new AssertionError();
        }

        return output;
    }
}
