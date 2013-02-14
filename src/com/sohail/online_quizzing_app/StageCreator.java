/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author sohail.alam
 */
public class StageCreator{
    
    private Stage stage;
    private static StageCreator instance;
    
    public static StageCreator getInstance(){
        if (instance == null) {
            return instance = new StageCreator();
        } else {
            return instance;
        }
    }
    
    private StageCreator(){
        
    }
    
    public void createNewStage(String fxml_path, String css_path){
        try {
            if (stage == null) {
                stage = new Stage();
            }
            Parent page = (Parent) FXMLLoader.load(getClass().getResource(fxml_path), null, new JavaFXBuilderFactory());
            Scene scene = new Scene(page);
            scene.getStylesheets().add(getClass().getResource(css_path).toExternalForm());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void exitNewStage(){
        stage.close();
        stage = null;
    }
}
