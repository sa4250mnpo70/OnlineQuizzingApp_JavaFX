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

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class AdminManageQuizController implements Initializable {

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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
