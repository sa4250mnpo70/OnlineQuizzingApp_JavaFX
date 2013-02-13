/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import com.sohail.online_quizzing_app.model.Metadata;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class AdminAddNewQuizController implements Initializable {

    @FXML
    private TextField subject;
    @FXML
    private TextField topic;
    @FXML
    private TextField time_limit;
    @FXML
    private TextField due_date;
    @FXML
    private TextField total_quiz_questions;
    @FXML
    private TextField total_questions_to_solve;
    @FXML
    private TextArea description;
    @FXML
    private Button cancel;
    @FXML
    private Button start;
    private Metadata metadata = Metadata.getInstance();

    public void enableTopic(KeyEvent event) {
        cancel.setDisable(false);
        topic.setDisable(false);
    }

    public void enableTimeLimitAndDueDate(KeyEvent event) {
        time_limit.setDisable(false);
        due_date.setDisable(false);
    }

    public void enableTotalQToSolve(KeyEvent event) {
        total_questions_to_solve.setDisable(false);
    }

    public void enableDescriptionAndTotalQ(KeyEvent event) {
        total_quiz_questions.setDisable(false);
        description.setDisable(false);
    }

    public void enableStartButton(KeyEvent event) {
        start.setDisable(false);
    }

    /*
     * Show the Admin Add Question Scene 
     * @param event 
     */
    public void buttonEventStart(ActionEvent event) {

        //Save the details to Quiz Metadata
        String subject_value = subject.getText();
        String topic_value = topic.getText();
        String time_limit_value = time_limit.getText();
        String due_date_value = due_date.getText();
        String description_value = description.getText();
        String total_Q_value = total_quiz_questions.getText();
        String total_Q_to_solve_value = total_questions_to_solve.getText();

        //Get Today's date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String date = dateFormat.format(cal.getTime());

        HashMap<String, String> quiz_metadata = new HashMap<>(8);

        quiz_metadata.put("subject", subject_value);
        quiz_metadata.put("topic", topic_value);
        quiz_metadata.put("time_limit", time_limit_value);
        quiz_metadata.put("due_date", due_date_value);
        quiz_metadata.put("description", description_value);
        quiz_metadata.put("total_questions", total_Q_value);
        quiz_metadata.put("total_questions_to_solve", total_Q_to_solve_value);
        quiz_metadata.put("submission_date", date);
        quiz_metadata.put("uuid", UUID.randomUUID().toString());

        metadata.setQuizMetadata(quiz_metadata);

        //Load the Add Question Scene
        SceneLoaders.getInstance().gotoAdminAddQuestion(OnlineQuizzingApp.getInstance().getStage());
    }

    public void buttonEventCancel(ActionEvent event) {
        subject.clear();
        subject.requestFocus();
        topic.clear();
        topic.setDisable(true);
        time_limit.clear();
        time_limit.setDisable(true);
        due_date.clear();
        due_date.setDisable(true);
        description.clear();
        description.setDisable(true);
        total_quiz_questions.clear();
        total_quiz_questions.setDisable(true);
        total_questions_to_solve.clear();
        total_questions_to_solve.setDisable(true);
        cancel.setDisable(true);
        start.setDisable(true);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        subject.requestFocus();
    }
}
