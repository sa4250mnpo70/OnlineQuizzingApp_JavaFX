/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import com.sohail.online_quizzing_app.model.Metadata;
import com.sohail.online_quizzing_app.model.SerializeXML;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class _AdminQuizRightSidebarController implements Initializable {

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
    
    public void createNextQuestion(ActionEvent event){
        Metadata metadata = Metadata.getInstance();
        SerializeXML.getInstance().AddQuestionsToQuiz(metadata.getQuestionMetadata());
        
        SceneLoaders.getInstance().gotoAdminAddQuestion(OnlineQuizzingApp.getInstance().getStage());
        
        //SerializeXML.getInstance().clearOptionList();
    }
    
    public void publishQuiz(ActionEvent event){
        try {
            SerializeXML.getInstance().doQuizSerialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb  
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
