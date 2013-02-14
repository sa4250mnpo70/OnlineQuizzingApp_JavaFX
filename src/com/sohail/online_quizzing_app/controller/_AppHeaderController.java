/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.AllScenesInterface;
import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class _AppHeaderController implements Initializable {
    
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private ImageView imageView_appLogo;
    @FXML
    private Text txt_headerTitle;
    @FXML
    private Button btn_appToggleFullScreen;
    @FXML
    private Button btn_appHelp;
    @FXML
    private Button btn_appAbout;
    @FXML
    private Button btn_appExit;
    @FXML
    private Button btn_appLogout;
    @FXML
    private Text txt_headerInfo;
    @FXML
    private Text txt_headerUserLoggedInName;

    //*********** All Events Common To Entire Application
    /**
     *
     * @param event
     */
    public void handleAppAboutButtonEvent(ActionEvent event) {
        //
    }

    /**
     *
     * @param event
     */
    public void handleAppHelpButtonEvent(ActionEvent event) {
        //
    }

    /**
     *
     * @param event
     */
    public void handleAppExitButtonAction(ActionEvent event) {
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

    /**
     * Toggle Full Screen Behavior
     *
     * @param event
     */
    public void handleAppToggleFullScreenButtonAction(ActionEvent event) {
        if (OnlineQuizzingApp.getInstance().getStage().isFullScreen()) {
            OnlineQuizzingApp.getInstance().getStage().setFullScreen(false);
        } else {
            OnlineQuizzingApp.getInstance().getStage().setFullScreen(true);
        }
    }
    
    public void setHeaderTitle(String message, double duration, String message_type) {
        
        txt_headerTitle.setText(message);
        
        switch (message_type) {
            case "OK":
                txt_headerTitle.setFill(Color.LIGHTYELLOW);
                break;
            case "INFO":
                txt_headerTitle.setFill(Color.LIGHTGREEN);
                break;
            case "WARNING":
                txt_headerTitle.setFill(Color.ORANGERED);
                break;
            case "ERROR":
                txt_headerTitle.setFill(Color.RED);
                break;
            default:
                throw new AssertionError();
        }
        
        FadeTransition ft = new FadeTransition(
                Duration.millis(duration), txt_headerTitle);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.play();
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
        String stageTitle = OnlineQuizzingApp.getInstance().getStage().getTitle();
        try {
            
            if (stageTitle.equals(AllScenesInterface.ONLINE_QUIZZING_APP_FXML)) {
                txt_headerInfo.setVisible(false);
                txt_headerUserLoggedInName.setVisible(false);
                btn_appLogout.setVisible(false);
            } else {
                txt_headerInfo.setVisible(true);
                txt_headerUserLoggedInName.setVisible(true);
                btn_appLogout.setVisible(true);
            }
            
            switch (stageTitle) {
                case AllScenesInterface.ADMIN_ADD_NEW_QUIZ_FXML:
                    setHeaderTitle("ADMIN_ADD_NEW_QUIZ_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.ADMIN_ADD_OPTION_FXML:
                    setHeaderTitle("ADMIN_ADD_OPTION_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.ADMIN_ADD_QUESTION_FXML:
                    setHeaderTitle("ADMIN_ADD_QUESTION_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.ADMIN_HOME_FXML:
                    setHeaderTitle("ADMIN_HOME_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.ADMIN_MANAGE_QUIZ_FXML:
                    setHeaderTitle("ADMIN_MANAGE_QUIZ_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.ADMIN_MANAGE_USERS_FXML:
                    setHeaderTitle("ADMIN_MANAGE_USERS_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.ADMIN_VIEW_QUIZ_FXML:
                    setHeaderTitle("ADMIN_VIEW_QUIZ_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.ADMIN_VIEW_SCORES_FXML:
                    setHeaderTitle("ADMIN_VIEW_SCORES_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.ONLINE_QUIZZING_APP_FXML:
                    setHeaderTitle("ONLINE_QUIZZING_APP_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.SIGNUP_FXML:
                    setHeaderTitle("SIGNUP_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.STUDENT_HOME_FXML:
                    setHeaderTitle("STUDENT_HOME_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.STUDENT_QUIZ_FXML:
                    setHeaderTitle("STUDENT_QUIZ_FXML", 5000, "OK");
                    break;
                case AllScenesInterface.STUDENT_QUIZ_FINISH_FXML:
                    setHeaderTitle("STUDENT_QUIZ_FINISH_FXML", 5000, "OK");
                    break;
                default:
                    txt_headerTitle.setText("");
                    break;
            }
        } catch (Exception e) {
        }
    }
}
