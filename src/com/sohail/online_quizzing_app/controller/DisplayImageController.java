/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.StageCreator;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class DisplayImageController implements Initializable {

    @FXML
    private ImageView imageView;

    public void exitImageView(MouseEvent event) {
        StageCreator.getInstance().exitNewStage();
    }

    public void setImageView(Image image) {
        imageView.setImage(image);
    }

    public void setImageView(InputStream imageInputStream) {
        imageView.setImage(new Image(imageInputStream));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Show image
    }
}
