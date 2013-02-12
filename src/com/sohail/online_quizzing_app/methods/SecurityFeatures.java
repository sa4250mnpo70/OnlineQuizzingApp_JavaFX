/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.methods;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

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

    public byte[] Encrypt(final String ENCRYPT_METHOD, final String DATA, final String KEY) throws Exception {

        KeyGenerator key = null;
        SecretKey sec = null;
        byte[] raw = null;
        byte[] encrypted = null;
        SecretKeySpec secSpec = null;
        Cipher cip = null;

        try {
            switch (ENCRYPT_METHOD) {
                case "AES":
                    key = KeyGenerator.getInstance("AES");
                    key.init(128);
                    sec = key.generateKey();
                    raw = sec.getEncoded();
                    secSpec = new SecretKeySpec(raw, "AES");
                    cip = Cipher.getInstance("AES");
                    cip.init(Cipher.ENCRYPT_MODE, secSpec);
                    encrypted = cip.doFinal(DATA.getBytes());

                    /* TEST */
                    String new_key = new String(raw);
                    System.out.println("KEY: " + new_key);



                    break;
                default:
                    throw new AssertionError();
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            throw ex;
        }
        return encrypted;
    }
}
