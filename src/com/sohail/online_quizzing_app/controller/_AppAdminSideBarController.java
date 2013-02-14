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
import javafx.scene.input.MouseEvent;

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

    //*********** All Events Common To ADMIN Section
    /*
     * Show the Admin Home Scene
     * @param event 
     */
    public void handleAdminHomeButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminHome(OnlineQuizzingApp.getInstance().getStage());
    }

    /*
     * Show the User Management Scene 
     * @param event 
     */
    public void handleAdminManageUsersButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminManageUsers(OnlineQuizzingApp.getInstance().getStage());
    }

    /*
     * Show the Quiz Management Scene 
     * @param event 
     */
    public void handleAdminManageQuizButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminManageQuiz(OnlineQuizzingApp.getInstance().getStage());
    }

    /*
     * Show the Quiz Management Scene 
     * @param event 
     */
    public void handleAdminViewQuizButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminViewQuiz(OnlineQuizzingApp.getInstance().getStage());
    }

    /*
     * Show the Quiz Management Scene 
     * @param event 
     */
    public void handleAdminViewScoresButtonEvent(ActionEvent event) {
        //Load the user management scene
        SceneLoaders.getInstance().gotoAdminViewScores(OnlineQuizzingApp.getInstance().getStage());
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
        OnlineQuizzingApp.getInstance().getStage().getTitle();
    }
}
