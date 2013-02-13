/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.stage.FileChooser;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author sohail.alam
 */
public class ManageImages {

    private static ManageImages instance = new ManageImages();

    public static ManageImages getInstance() {
        return instance;
    }

    private ManageImages() {
    }

    public String read() {
        //Choose an image file
        FileChooser file_chooser = new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Images Only are allowed", "*.jpeg", "*.jpg", "*.gif", "*.bmp");
        file_chooser.getExtensionFilters().add(extFilter);
        //Show open file dialog
        File image_file = file_chooser.showOpenDialog(null);
        FileInputStream image_stream = null;
        byte[] image_bytes = null;
        String image_data = null;
        try {
            image_stream = new FileInputStream(image_file);
            image_bytes = new byte[(int) image_file.length()];
            image_stream.read(image_bytes);
            image_data = Base64.encodeBase64String(image_bytes);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                image_stream.close();
            } catch (IOException ex) {
            }
        }
        return image_data;
    }

    public void write(String image_data) {
        //Decode image data
        byte[] image_byte_array = Base64.decodeBase64(image_data);

        FileChooser file_chooser = new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Images Only are allowed", "*.jpeg", "*.jpg", "*.gif", "*.bmp");
        file_chooser.getExtensionFilters().add(extFilter);
        //Show open file dialog
        File image_file = file_chooser.showSaveDialog(null);

        // Write a image byte array into file system
        FileOutputStream imageOutFile = null;
        try {
            imageOutFile = new FileOutputStream(image_file.getAbsolutePath());
            imageOutFile.write(image_byte_array);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                imageOutFile.close();
            } catch (IOException ex) {
                
            }
        }
    }
}
