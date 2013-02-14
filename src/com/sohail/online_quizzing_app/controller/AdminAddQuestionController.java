/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import com.sohail.online_quizzing_app.methods.ManageImages;
import com.sohail.online_quizzing_app.model.Metadata;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class AdminAddQuestionController implements Initializable {

    @FXML
    private TextArea question;
    @FXML
    private ComboBox<String> difficulty;
    @FXML
    private Button select_image;
    @FXML
    private Button cancel;
    @FXML
    private Button clear;
    @FXML
    private Button save;
    String image_data = null;
    private Metadata metadata = Metadata.getInstance();

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

    public void enableCancelAndClearKeyEvent(KeyEvent event) {
        cancel.setDisable(false);
        clear.setDisable(false);
        difficulty.setDisable(false);
    }

    public void enableSave(ActionEvent event) {
        if (!difficulty.getValue().toString().equals("Select A Difficulty Level")) {
            save.setDisable(false);
        } else {
            save.setDisable(true);
        }
    }

    public void selectImage(ActionEvent event) {
        cancel.setDisable(false);
        clear.setDisable(false);
        difficulty.setDisable(false);
        image_data = ManageImages.getInstance().read();
    }

    public void buttonEventCancel(ActionEvent event) {
    }

    public void buttonEventClear(ActionEvent event) {
        question.clear();
        difficulty.setValue("Select A Difficulty Level");
        save.setDisable(true);
        clear.setDisable(true);
        cancel.setDisable(true);
    }

    public void buttonEventSave(ActionEvent event) {
        //Save details to Question Metadata
        String question_value = question.getText();
        String difficulty_value = difficulty.getValue().toString();
        int question_no = Integer.parseInt(metadata.getQuestionMetadata().get("question_number"));
        question_no++;
        HashMap<String, String> map = new HashMap<>(6);
        map.put("question", question_value);
        map.put("question_image", image_data);
        map.put("difficulty", difficulty_value);
        map.put("question_number", String.valueOf(question_no));
        map.put("uuid", UUID.randomUUID().toString());
        map.put("uuid_quiz", metadata.getQuizMetadata().get("uuid"));
        metadata.setQuestionMetadata(map);

        //Load the Add Option Scene
        SceneLoaders.getInstance().gotoAdminAddOption(OnlineQuizzingApp.getInstance().getStage());
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Set the options for Difficulty Level
        ObservableList<String> options = FXCollections.observableArrayList(
                "Select A Difficulty Level",
                "Kid's Level",
                "You Can Do It",
                "Think About It",
                "Mind Boggling!");
        difficulty.setItems(options);
    }
}
