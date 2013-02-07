/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author SOHAIL
 */
public class AdminManageUsersController implements Initializable {


	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}
	
	/*
	 * Display an about page
	 *
	 * @param event
	 */
	@FXML
	private void handleAppAboutButtonEvent(ActionEvent event) {
		CommonEventHandlers.getInstance().handleAppAboutButtonEvent(event);
	}

	/*
	 * Show a help window
	 *
	 * @param event
	 */
	@FXML
	private void handleAppHelpButtonEvent(ActionEvent event) {
		CommonEventHandlers.getInstance().handleAppHelpButtonEvent(event);
	}

	/*
	 * Exit from the application
	 *
	 * @param event
	 */
	@FXML
	private void handleAppExitButtonAction(ActionEvent event) {
		CommonEventHandlers.getInstance().handleAppExitButtonAction(event);
	}

	/*
	 * Logout the user, but keep the app running. Also, redirect to the login
	 * page
	 *
	 * @param event
	 */
	@FXML
	private void handleAppLogoutButtonAction(ActionEvent event) {
		CommonEventHandlers.getInstance().handleAppLogoutButtonAction(event);
	}
	
	/*
	 * Show the Admin Home Scene 
	 * @param event 
	 */
	@FXML
	private void handleAdminHomeButtonEvent(ActionEvent event) {
		//Load the user management scene
		CommonEventHandlers.getInstance().handleAdminHomeButtonEvent(event);
	}
	
	/*
	 * Show the Quiz Management Scene 
	 * @param event 
	 */
	@FXML
	private void handleAdminManageQuizButtonEvent(ActionEvent event) {
		//Load the user management scene
		CommonEventHandlers.getInstance().handleAdminManageQuizButtonEvent(event);
	}
	
	/*
	 * Show the Quiz Management Scene 
	 * @param event 
	 */
	@FXML
	private void handleAdminViewQuizButtonEvent(ActionEvent event) {
		//Load the user management scene
		CommonEventHandlers.getInstance().handleAdminViewQuizButtonEvent(event);
	}
	
	/*
	 * Show the Quiz Management Scene 
	 * @param event 
	 */
	@FXML
	private void handleAdminViewScoresButtonEvent(ActionEvent event) {
		//Load the user management scene
		CommonEventHandlers.getInstance().handleAdminViewScoresButtonEvent(event);
	}
}
