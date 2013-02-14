/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author sohail.alam
 */
public class OnlineQuizzingApp extends Application {

    private static boolean isLoggedIn = false;
    private static OnlineQuizzingApp instance;

    public static OnlineQuizzingApp getInstance() {
        return instance;
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @return the isLoggedIn
     */
    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    /**
     * @param isLoggedIn the isLoggedIn to set
     */
    public static void setIsLoggedIn(boolean isLoggedIn) {
        OnlineQuizzingApp.isLoggedIn = isLoggedIn;
    }
    private Stage stage;

    public OnlineQuizzingApp() {
        instance = this;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Run the bootstarp
        BootStrap.getInstance().Initialize();
        try {
            stage = primaryStage;
            SceneLoaders.getInstance().gotoLogin(getStage());
            primaryStage.show();
        } catch (Exception ex) {
            //Handle Exception
        }
    }

    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }
}
