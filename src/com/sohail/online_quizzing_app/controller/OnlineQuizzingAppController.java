/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author sohail.alam
 */
public class OnlineQuizzingAppController implements Initializable {

	@FXML
	private Button btn_appHelp;
	@FXML
	private Button btn_appAbout;
	@FXML
	private Button btn_appExit;
	@FXML
	private Button btn_appLogout;
	@FXML
	private Button btn_login;
	@FXML
	private Button btn_signup;
	@FXML
	private Text txt_headerInfo;
	@FXML
	private Text txt_headerUserLoggedInName;
	@FXML
	private Text txt_loginMessage;
	@FXML
	private Text txt_signupMessage;
	@FXML
	private TextField txtbox_loginUsername;
	@FXML
	private PasswordField txtbox_loginPassword;
	@FXML
	private TextField txtbox_signupEmail;
	@FXML
	private TextField txtbox_signupUsername;
	@FXML
	private PasswordField txtbox_signupPassword;
	@FXML
	private PasswordField txtbox_signupPassword2;

	/**
	 *
	 * @param url
	 * @param rb
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	/**
	 * Exit from the application
	 *
	 * @param event
	 */
	@FXML
	private void handleAppExitButtonAction(ActionEvent event) {
		System.exit(0);
	}
}
