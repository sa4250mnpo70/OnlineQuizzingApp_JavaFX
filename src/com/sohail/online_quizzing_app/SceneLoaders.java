/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app;

import static com.sohail.online_quizzing_app.AllScenesInterface.ADMIN_ADD_QUESTION_CSS;
import static com.sohail.online_quizzing_app.AllScenesInterface.ADMIN_ADD_QUESTION_FXML;
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

    public static SceneLoaders getInstance() {
        return instance;
    }

    private SceneLoaders() {
    }

    /*
     * This is the Login Scene
     */
    public void gotoLogin(Stage stage) {
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
    public void gotoAdminHome(Stage stage) {
        try {
            replaceSceneContent(ADMIN_HOME_FXML, ADMIN_HOME_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin User Management Scene
     */
    public void gotoAdminManageUsers(Stage stage) {
        try {
            replaceSceneContent(ADMIN_MANAGE_USERS_FXML, ADMIN_MANAGE_USERS_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin User Management Scene
     */
    public void gotoAdminManageQuiz(Stage stage) {
        try {
            replaceSceneContent(ADMIN_MANAGE_QUIZ_FXML, ADMIN_MANAGE_QUIZ_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin User Management Scene
     */
    public void gotoAdminViewQuiz(Stage stage) {
        try {
            replaceSceneContent(ADMIN_VIEW_QUIZ_FXML, ADMIN_VIEW_QUIZ_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin User Management Scene
     */
    public void gotoAdminViewScores(Stage stage) {
        try {
            replaceSceneContent(ADMIN_VIEW_SCORES_FXML, ADMIN_VIEW_SCORES_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin Add New Quiz
     */
    public void gotoAdminAddNewQuiz(Stage stage) {
        try {
            replaceSceneContent(ADMIN_ADD_NEW_QUIZ_FXML, ADMIN_ADD_NEW_QUIZ_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Admin Add Question & Option
     */
    public void gotoAdminAddQuestion(Stage stage) {
        try {
            replaceSceneContent(ADMIN_ADD_QUESTION_FXML, ADMIN_ADD_QUESTION_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoAdminAddOption(Stage stage) {
        try {
            replaceSceneContent(ADMIN_ADD_OPTION_FXML, ADMIN_ADD_OPTION_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoSignup(Stage stage) {
        try {
            replaceSceneContent(SIGNUP_FXML, SIGNUP_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoStudentHome(Stage stage) {
        try {
            replaceSceneContent(STUDENT_HOME_FXML, STUDENT_HOME_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoStudentQuiz(Stage stage) {
        try {
            replaceSceneContent(STUDENT_QUIZ_FXML, STUDENT_QUIZ_CSS, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoStudentQuizFinish(Stage stage) {
        try {
            replaceSceneContent(STUDENT_QUIZ_FINISH_FXML, STUDENT_QUIZ_FINISH_CSS, stage);
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
    public Parent replaceSceneContent(String fxml, String stylesheet, Stage stage) throws Exception {

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
    public void doFullScreen(boolean doFullScreen, Stage stage) {
        try {
            stage.setFullScreen(doFullScreen);
        } catch (Exception e) {
        }
    }
}
