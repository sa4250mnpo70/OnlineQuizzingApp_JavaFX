/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.stage.FileChooser;

/**
 *
 * @author SOHAIL
 */
public class ManageFiles {
    private static ManageFiles instance;
    
    public static ManageFiles getInstance(){
        if (instance == null) {
            return instance = new ManageFiles();
        } else {
            return instance;
        }
    }
    
    private ManageFiles(){
        
    }
    
    public void write(String data){
        
        FileChooser file_chooser = new FileChooser();
        //Show open file dialog
        File file = file_chooser.showSaveDialog(null);

        // Write data into file system
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            fileOutputStream.write(data.getBytes());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                
            }
        }
    }
}
