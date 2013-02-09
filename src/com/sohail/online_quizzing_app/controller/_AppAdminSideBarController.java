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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class _AppAdminSideBarController implements Initializable {

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
    
    //*********** All Events Common To ADMIN Section
    /*
     * Show the Admin Home Scene
     * @param event 
     */
    synchronized public void handleAdminHomeButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminHome(OnlineQuizzingApp.getInstance().getStage());
    }

    /*
     * Show the User Management Scene 
     * @param event 
     */
    synchronized public void handleAdminManageUsersButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminManageUsers(OnlineQuizzingApp.getInstance().getStage());
    }

    /*
     * Show the Quiz Management Scene 
     * @param event 
     */
    synchronized public void handleAdminManageQuizButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminManageQuiz(OnlineQuizzingApp.getInstance().getStage());
    }

    /*
     * Show the Quiz Management Scene 
     * @param event 
     */
    synchronized public void handleAdminViewQuizButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminViewQuiz(OnlineQuizzingApp.getInstance().getStage());
    }

    /*
     * Show the Quiz Management Scene 
     * @param event 
     */
    synchronized public void handleAdminViewScoresButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminViewScores(OnlineQuizzingApp.getInstance().getStage());
    }
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        OnlineQuizzingApp.getInstance().getStage().getTitle();
    }    
}
