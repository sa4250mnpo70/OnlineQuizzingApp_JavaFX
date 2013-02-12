/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import com.sohail.online_quizzing_app.model.Metadata;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class AdminAddOptionController implements Initializable {

    private Metadata metadata = Metadata.getInstance();
    @FXML
    private TextArea question;
    @FXML
    private CheckBox correct_answer;
    @FXML
    private Button select_image;
    @FXML
    private Button cancel;
    @FXML
    private Button clear;
    @FXML
    private Button save;

    public void enableCancelAndClearKeyEvent(KeyEvent event) {
        cancel.setDisable(false);
        clear.setDisable(false);
        save.setDisable(false);
        correct_answer.setDisable(false);
    }

    public void selectImage(ActionEvent event) {
        cancel.setDisable(false);
        clear.setDisable(false);
    }

    public void buttonEventCancel(ActionEvent event) {
    }

    public void buttonEventClear(ActionEvent event) {
        question.clear();
        correct_answer.setSelected(false);
        save.setDisable(true);
        clear.setDisable(true);
        cancel.setDisable(true);
    }

    public void buttonEventSave(ActionEvent event) {
        //Save details to Question Metadata
        String option_value = question.getText();
        String image_value = getImage();
        String correct_answer_value;
        if (correct_answer.isSelected()) {
            correct_answer_value = "true";
        } else {
            correct_answer_value = "false";
        }
        int option_no = Integer.parseInt(metadata.getOptionMetadata().get("option_number"));
        option_no++;

        HashMap<String, String> map = new HashMap<>(6);
        map.put("option", option_value);
        map.put("option_image", image_value);
        map.put("correct_answer", correct_answer_value);
        map.put("option_number", String.valueOf(option_no));
        map.put("uuid", UUID.randomUUID().toString());
        map.put("uuid_quiz", metadata.getQuizMetadata().get("uuid"));
        map.put("uuid_question", metadata.getQuestionMetadata().get("uuid"));
        metadata.setOptionMetadata(map);
        
        //TEST
        testModelHashMapEntries();
        
        //Load the Add Option Scene
        SceneLoaders.getInstance().gotoAdminAddOption(OnlineQuizzingApp.getInstance().getStage());
    }

    private String getImage() {
        return "Image selection is not yet supported";
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        correct_answer.setSelected(false);
    }

    private void testModelHashMapEntries() {
        Iterator<String> iterator = null;
        // TEST
        System.out.println("***** QUIZ *****");
        HashMap<String, String> metadata_quiz = metadata.getQuizMetadata();
        iterator = metadata_quiz.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = metadata_quiz.get(key).toString();
            System.out.println(key + ": " + value);
        }

        // TEST
        System.out.println("***** QUESTION *****");
        HashMap<String, String> metadata_question = metadata.getQuestionMetadata();
        iterator = metadata_question.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = metadata_question.get(key).toString();
            System.out.println(key + ": " + value);
        }

        // TEST
        System.out.println("***** OPTION *****");
        HashMap<String, String> metadata_option = metadata.getOptionMetadata();
        iterator = metadata_option.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = metadata_option.get(key).toString();
            System.out.println(key + ": " + value);
        }
    }
}
