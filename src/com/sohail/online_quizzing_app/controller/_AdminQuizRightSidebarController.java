/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.AllScenesInterface;
import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import com.sohail.online_quizzing_app.methods.ManageFiles;
import com.sohail.online_quizzing_app.model.Metadata;
import com.sohail.online_quizzing_app.model.SerializeXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class _AdminQuizRightSidebarController implements Initializable {

    @FXML
    private Label total_q_added_label;
    @FXML
    private TextField total_q_added;
    @FXML
    private ComboBox<String> select_q;
    @FXML
    private Button delete;
    @FXML
    private Button previous;
    @FXML
    private Button next;
    @FXML
    private Button update;
    @FXML
    private Button createNextQuestion;
    @FXML
    private Button publish_quiz;

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

    public void createNextQuestion(ActionEvent event) {
        Metadata metadata = Metadata.getInstance();
        SerializeXML.getInstance().addQuestionsToQuiz(metadata.getQuestionMetadata());
        SceneLoaders.getInstance().gotoAdminAddQuestion(OnlineQuizzingApp.getInstance().getStage());
    }

    public void publishQuiz(ActionEvent event) {
        ManageFiles manageFiles = ManageFiles.getInstance();
        try {
            manageFiles.write(SerializeXML.getInstance().doQuizSerialize());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Metadata metadata = Metadata.getInstance();
        String stageTitle = OnlineQuizzingApp.getInstance().getStage().getTitle();
        if (stageTitle.equals(AllScenesInterface.ADMIN_ADD_QUESTION_FXML)) {
            //Update the total number of questions
            total_q_added_label.setText("Total Questions Added :");
            total_q_added.setText(metadata.getQuestionMetadata().get("question_number"));
        } else if (stageTitle.equals(AllScenesInterface.ADMIN_ADD_OPTION_FXML)) {
            //Update the total number of questions
            total_q_added_label.setText("Total Options Added :");
            total_q_added.setText(metadata.getOptionMetadata().get("option_number"));
        }
    }
}
