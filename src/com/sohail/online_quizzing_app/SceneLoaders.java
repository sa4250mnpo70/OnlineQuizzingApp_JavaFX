/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app;

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
public class SceneLoaders implements AllScenesInterface {

    /*
     * Making it a singleton class
     */
    private static SceneLoaders instance = new SceneLoaders();

    private SceneLoaders() {
    }

    public static SceneLoaders getInstance() {
        return instance;
    }

    /*
     * This is the Login Scene
     */
    synchronized public void gotoLogin(Stage stage) {
        try {
            replaceSceneContent(ONLINE_QUIZZING_APP_FXML, ONLINE_QUIZZING_APP_CSS, stage);
        } catch (Exception ex) {
            //Handle Exception
            ex.printStackTrace();
        }
    }

    /*
     * Admin Home Scene
     */
    synchronized public void gotoAdminHome(Stage stage) {
        try {
            replaceSceneContent(ADMIN_HOME_FXML, ADMIN_HOME_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin User Management Scene
     */
    synchronized public void gotoAdminManageUsers(Stage stage) {
        try {
            replaceSceneContent(ADMIN_MANAGE_USERS_FXML, ADMIN_MANAGE_USERS_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin User Management Scene
     */
    synchronized public void gotoAdminManageQuiz(Stage stage) {
        try {
            replaceSceneContent(ADMIN_MANAGE_QUIZ_FXML, ADMIN_MANAGE_QUIZ_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin User Management Scene
     */
    synchronized public void gotoAdminViewQuiz(Stage stage) {
        try {
            replaceSceneContent(ADMIN_VIEW_QUIZ_FXML, ADMIN_VIEW_QUIZ_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin User Management Scene
     */
    synchronized public void gotoAdminViewScores(Stage stage) {
        try {
            replaceSceneContent(ADMIN_VIEW_SCORES_FXML, ADMIN_VIEW_SCORES_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method replaces one scene with another. No need to call it
     * explicitely.
     *
     * @param fxml The relative path to the fxml file needed to be loaded
     * @param stylesheet The relative path to the stylesheet needed to be loaded
     * @param stage The stage to which the scene needs to be loaded
     * @return
     * @throws Exception
     */
    synchronized public Parent replaceSceneContent(String fxml, String stylesheet, Stage stage) throws Exception {

        stage.setTitle(fxml);
        Parent page = (Parent) FXMLLoader.load(OnlineQuizzingApp.class.getResource(fxml), null, new JavaFXBuilderFactory());
        Scene scene = stage.getScene();
        if (scene == null) {
            scene = new Scene(page);
            scene.getStylesheets().add(OnlineQuizzingApp.class.getResource(stylesheet).toExternalForm());
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
        } else {
            stage.getScene().setRoot(page);
        }
        //stage.sizeToScene();
        return page;
    }

    /*
     * Use this method to switch between Full Screen Mode and Normal Screen Mode.
     */
    synchronized public void doFullScreen(boolean doFullScreen, Stage stage) {
        try {
            stage.setFullScreen(doFullScreen);
        } catch (Exception e) {
        }
    }
}
