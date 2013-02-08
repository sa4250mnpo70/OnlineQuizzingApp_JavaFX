/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author sohail.alam
 */
public class AdminHomeController extends CommonEventHandlers implements Initializable {

    @FXML
    private Button btn_adminHome;
    @FXML
    private Button btn_adminManageUsers;
    @FXML
    private Button btn_adminManageQuiz;
    @FXML
    private Button btn_adminViewQuiz;
    @FXML
    private Button btn_adminViewScores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
