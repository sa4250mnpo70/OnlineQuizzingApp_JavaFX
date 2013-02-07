/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author sohail.alam
 */
public class CommonEventHandlers {
	
	private static CommonEventHandlers instance = new CommonEventHandlers();
	
	private CommonEventHandlers(){
		
	}
	
	public static CommonEventHandlers getInstance(){
		return instance;
	}
	
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
	
	//*********** All Events Common To ADMIN Section
	
	/*
	 * Show the Admin Home Scene
	 * @param event 
	 */
	public void handleAdminHomeButtonEvent(ActionEvent event) {
		//Load the user management scene
		SceneLoaders.getInstance().gotoAdminHome(OnlineQuizzingApp.getInstance().getStage());
	}
	
	/*
	 * Show the User Management Scene 
	 * @param event 
	 */
	public void handleAdminManageUsersButtonEvent(ActionEvent event) {
		//Load the user management scene
		SceneLoaders.getInstance().gotoAdminManageUsers(OnlineQuizzingApp.getInstance().getStage());
	}
	
	/*
	 * Show the Quiz Management Scene 
	 * @param event 
	 */
	public void handleAdminManageQuizButtonEvent(ActionEvent event) {
		//Load the user management scene
		SceneLoaders.getInstance().gotoAdminManageQuiz(OnlineQuizzingApp.getInstance().getStage());
	}
	
	/*
	 * Show the Quiz Management Scene 
	 * @param event 
	 */
	public void handleAdminViewQuizButtonEvent(ActionEvent event) {
		//Load the user management scene
		SceneLoaders.getInstance().gotoAdminViewQuiz(OnlineQuizzingApp.getInstance().getStage());
	}
	
	/*
	 * Show the Quiz Management Scene 
	 * @param event 
	 */
	public void handleAdminViewScoresButtonEvent(ActionEvent event) {
		//Load the user management scene
		SceneLoaders.getInstance().gotoAdminViewScores(OnlineQuizzingApp.getInstance().getStage());
	}
}
