/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.fxdialogbox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 *
 * @author sohail.alam
 */
public class FXDialogBoxController implements Initializable {

    @FXML
    private Text txt_dialogHeader;
    @FXML
    private ImageView image_dialogHeader;
    @FXML
    private TextArea txtfld_dialogContent;
    @FXML
    private Button btn_dialogAccept;
    @FXML
    private Button btn_dialogDecline;
    @FXML
    private Button btn_dialogCancel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
