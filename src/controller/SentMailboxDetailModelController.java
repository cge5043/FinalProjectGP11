/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import model.Sentemail;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class SentMailboxDetailModelController implements Initializable {

    @FXML
    private TextArea labelText;
    @FXML
    private ImageView image;
    @FXML
    private Label labelTitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
     Sentemail selectedModel;

   // set email text and sender
    public void initData(Sentemail model) {
        selectedModel = model;
        labelText.setText(model.getTextmessage());
        labelTitle.setText(model.getReciever());
    }
    
}
