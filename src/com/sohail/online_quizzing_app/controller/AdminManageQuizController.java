/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class AdminManageQuizController implements Initializable {

    /**
     * Click and Hold to make window draggable
     *
     * @param event
     */
    public void handleAppMouseClick_Hold(MouseEvent event) {
        CommonEventHandlers.getInstance().handleAppMouseClick_Hold(event);
    }

    /**
     * Drag to drag window
     *
     * @param event
     */
    public void handleAppMouseDrag(MouseEvent event) {
        CommonEventHandlers.getInstance().handleAppMouseDrag(event);
    }

    /*
     * Show the Admin Add Question Scene 
     * @param event 
     */
    public void handleAdminAddNewQuizButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminAddNewQuiz(OnlineQuizzingApp.getInstance().getStage());
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
