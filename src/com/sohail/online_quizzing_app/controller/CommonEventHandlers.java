/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.controller;

import com.sohail.online_quizzing_app.OnlineQuizzingApp;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author sohail.alam
 */
public class CommonEventHandlers {

    private static CommonEventHandlers instance = new CommonEventHandlers();

    public static CommonEventHandlers getInstance() {
        return instance;
    }
    private double xOffset;
    private double yOffset;

    private CommonEventHandlers() {
    }

    /**
     * Click and Hold to make window draggable
     *
     * @param event
     */
    public void handleAppMouseClick_Hold(MouseEvent event) {

        Stage stage = OnlineQuizzingApp.getInstance().getStage();

        xOffset = event.getSceneX();
        yOffset = event.getSceneY();

        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                if (stage.isFullScreen()) {
                    stage.setFullScreen(false);
                } else {
                    stage.setFullScreen(true);
                }
            }
        }
    }

    /**
     * Drag to drag window
     *
     * @param event
     */
    public void handleAppMouseDrag(MouseEvent event) {
        if (!OnlineQuizzingApp.getInstance().getStage().isFullScreen()) {
            OnlineQuizzingApp.getInstance().getStage().setX(event.getScreenX() - xOffset);
            OnlineQuizzingApp.getInstance().getStage().setY(event.getScreenY() - yOffset);
        }
    }
}
