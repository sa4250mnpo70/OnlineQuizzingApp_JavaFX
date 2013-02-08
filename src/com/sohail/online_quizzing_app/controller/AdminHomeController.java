/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class AdminHomeController implements Initializable {

    @FXML
    private Button btn_adminHome;
    @FXML
    private Button btn_adminManageUsers;
    @FXML
    private Button btn_adminManageQuiz;
    @FXML
    private Button btn_adminViewQuiz;
    @FXML
    private Button btn_adminViewScores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /*
     * Display an about page
     *
     * @param event
     */
    @FXML
    private void handleAppAboutButtonEvent(ActionEvent event) {
        CommonEventHandlers.getInstance().handleAppAboutButtonEvent(event);
    }

    /*
     * Show a help window
     *
     * @param event
     */
    @FXML
    private void handleAppHelpButtonEvent(ActionEvent event) {
        CommonEventHandlers.getInstance().handleAppHelpButtonEvent(event);
    }

    /*
     * Exit from the application
     *
     * @param event
     */
    @FXML
    private void handleAppExitButtonAction(ActionEvent event) {
        CommonEventHandlers.getInstance().handleAppExitButtonAction(event);
    }

    /*
     * Logout the user, but keep the app running. Also, redirect to the login
     * page
     *
     * @param event
     */
    @FXML
    private void handleAppLogoutButtonAction(ActionEvent event) {
        CommonEventHandlers.getInstance().handleAppLogoutButtonAction(event);
    }
    
    /**
     * Click and Hold to make window draggable
     * @param event 
     */
    @FXML
    private void handleAppMouseClick_Hold(MouseEvent event) {
        CommonEventHandlers.getInstance().handleAppMouseClick_Hold(event);
    }
    
    /**
     * Drag to drag window
     * @param event 
     */
    @FXML
    private void handleAppMouseDrag(MouseEvent event) {
        CommonEventHandlers.getInstance().handleAppMouseDrag(event);
    }


    /**
     * Toggle Full Screen Behavior
     *
     * @param event
     */
    public void handleAppToggleFullScreenButtonAction(ActionEvent event) {
        CommonEventHandlers.getInstance().handleAppToggleFullScreenButtonAction(event);
    }

    /*
     * Show the User Management Scene 
     * @param event 
     */
    @FXML
    private void handleAdminManageUsersButtonEvent(ActionEvent event) {
        //Load the user management scene
        CommonEventHandlers.getInstance().handleAdminManageUsersButtonEvent(event);
    }

    /*
     * Show the Quiz Management Scene 
     * @param event 
     */
    @FXML
    private void handleAdminManageQuizButtonEvent(ActionEvent event) {
        //Load the user management scene
        CommonEventHandlers.getInstance().handleAdminManageQuizButtonEvent(event);
    }

    /*
     * Show the Quiz Management Scene 
     * @param event 
     */
    @FXML
    private void handleAdminViewQuizButtonEvent(ActionEvent event) {
        //Load the user management scene
        CommonEventHandlers.getInstance().handleAdminViewQuizButtonEvent(event);
    }

    /*
     * Show the Quiz Management Scene 
     * @param event 
     */
    @FXML
    private void handleAdminViewScoresButtonEvent(ActionEvent event) {
        //Load the user management scene
        CommonEventHandlers.getInstance().handleAdminViewScoresButtonEvent(event);
    }
}
