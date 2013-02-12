/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.model.Metadata;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class AdminAddOptionController implements Initializable {
    private Metadata metadata = Metadata.getInstance();;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TEST
        HashMap<String, String> metadata_question = metadata.getQuestionMetadata();
        Iterator<String> iterator = metadata_question.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = metadata_question.get(key).toString();
            System.out.println(key + ": " + value);
        }
    }
}
