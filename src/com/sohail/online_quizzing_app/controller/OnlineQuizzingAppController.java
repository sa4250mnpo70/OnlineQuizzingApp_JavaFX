/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import com.sohail.online_quizzing_app.SceneLoaders;
import com.sohail.online_quizzing_app.methods.ValidateWithCommonRegEx;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author sohail.alam
 */
public class OnlineQuizzingAppController implements Initializable {

    @FXML
    private Button btn_login;
    @FXML
    private Button btn_signup;
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

    /*
     * Login User. If the username has attribute Admin, then take the user to
     * the Admin Page, else take the user to the non-admin page. Once logged in
     * disable the username/password fields, signup button, and change the text
     * of the login to logout.
     *
     * @param event
     */
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {

        String username = null;
        String password = null;
        //If not logged in then try to do so
        if (!OnlineQuizzingApp.isIsLoggedIn()) {
            //Disable them
            txtbox_loginUsername.setDisable(true);
            txtbox_loginPassword.setDisable(true);

            //Collect the data
            username = txtbox_loginUsername.getText().trim();
            username = txtbox_loginPassword.getText().trim();

            //Try To Login & If successful -> Change the login button text
            if (true) {
                OnlineQuizzingApp.setIsLoggedIn(true);
                txt_loginMessage.setText("Successfully Logged In");
                btn_login.setText("Logout");
                //TEST
                SceneLoaders.getInstance().gotoAdminHome(OnlineQuizzingApp.getInstance().getStage());
            } else {
            }
        } // If already logged in then try to logout and change the login button text
        else {
            if (true) {
                //Enable them
                txtbox_loginUsername.setDisable(false);
                txtbox_loginPassword.setDisable(false);

                //Clear the data
                txtbox_loginUsername.setText("");
                txtbox_loginPassword.setText("");

                OnlineQuizzingApp.setIsLoggedIn(false);
                txt_loginMessage.setText("Successfully Logged Out");
                btn_login.setText("Login");
            } else {
            }
        }
    }

    /*
     * Signup a new user, provided the username or email is not already taken.
     * If signup is successful, take the user directly to user profile page, 
     * which the user may skip at the moment.
     *
     * @param event
     */
    @FXML
    private void handleSignupButtonAction(ActionEvent event) {
        String email = null;
        String username = null;
        String password = null;
        String password2 = null;
    }

    /**
     * Validate Email ID
     *
     * @param event
     */
    @FXML
    private void handleSignupEmailKeyEvent(KeyEvent event) {

        String email = null;
        ValidateWithCommonRegEx validate;

        email = txtbox_signupEmail.getText().trim();
        validate = new ValidateWithCommonRegEx();

        if (!validate.ValidateWithCommonRegEx("EMAIL", true, email)) {
            txt_signupMessage.setText("Please enter a valid email");
        } else {
            txt_signupMessage.setText("Email ID Accepted");
            txtbox_signupUsername.setDisable(false);
        }
    }

    /**
     * Validate Username
     *
     * @param event
     */
    @FXML
    private void handleSignupUsernameKeyEvent(KeyEvent event) {

        String username = null;
        ValidateWithCommonRegEx validate;

        username = txtbox_signupUsername.getText().trim();
        validate = new ValidateWithCommonRegEx();

        if (!validate.ValidateWithCommonRegEx("USERNAME", true, username)) {
            txt_signupMessage.setText("Please enter a valid username");
        } else {
            txt_signupMessage.setText("Username Accepted");
            txtbox_signupPassword.setDisable(false);
        }
    }

    /**
     * Validate Password
     *
     * @param event
     */
    @FXML
    private void handleSignupPasswordKeyEvent(KeyEvent event) {

        String password = null;
        ValidateWithCommonRegEx validate;

        password = txtbox_signupPassword.getText().trim();
        validate = new ValidateWithCommonRegEx();

        if (!validate.ValidateWithCommonRegEx("PASSWORD", true, password)) {
            txt_signupMessage.setText("Please enter a valid password");
        } else {
            txt_signupMessage.setText("Password Accepted");
            txtbox_signupPassword2.setDisable(false);
        }
    }

    /**
     * Validate Second Password
     *
     * @param event
     */
    @FXML
    private void handleSignupPassword2KeyEvent(KeyEvent event) {

        String password = null;
        String password2 = null;

        password = txtbox_signupPassword.getText().trim();
        password2 = txtbox_signupPassword2.getText().trim();

        if (!password.matches(password2)) {
            txt_signupMessage.setText("Password Did Not Match");
        } else {
            txt_signupMessage.setText("Password Matched");
            btn_signup.setDisable(false);
        }
    }

    /*
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
