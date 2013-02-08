/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author sohail.alam
 */
public class CommonEventHandlers {

    private double xOffset = 0;
    private double yOffset = 0;
    private static CommonEventHandlers instance = new CommonEventHandlers();

    private CommonEventHandlers() {
    }

    public static CommonEventHandlers getInstance() {
        return instance;
    }

    //*********** All Events Common To Entire Application
    /**
     *
     * @param event
     */
    synchronized public void handleAppAboutButtonEvent(ActionEvent event) {
        //
    }

    /**
     *
     * @param event
     */
    synchronized public void handleAppHelpButtonEvent(ActionEvent event) {
        //
    }

    /**
     *
     * @param event
     */
    synchronized public void handleAppExitButtonAction(ActionEvent event) {
        System.exit(0);
    }

    /**
     *
     * @param event
     */
    public void handleAppLogoutButtonAction(ActionEvent event) {
        //
    }

    /**
     * Click and Hold to make window draggable
     * @param event 
     */
    public void handleAppMouseClick_Hold(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    /**
     * Drag to drag window
     * @param event 
     */
    public void handleAppMouseDrag(MouseEvent event) {
        OnlineQuizzingApp.getInstance().getStage().setX(event.getScreenX() - xOffset);
        OnlineQuizzingApp.getInstance().getStage().setY(event.getScreenY() - yOffset);
    }

    /**
     * Toggle Full Screen Behavior
     *
     * @param event
     */
    synchronized public void handleAppToggleFullScreenButtonAction(ActionEvent event) {
        if (OnlineQuizzingApp.getInstance().getStage().isFullScreen()) {
            OnlineQuizzingApp.getInstance().getStage().setFullScreen(false);
        } else {
            OnlineQuizzingApp.getInstance().getStage().setFullScreen(true);
        }
    }

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
}
