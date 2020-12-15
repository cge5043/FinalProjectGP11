/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.Todolist;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class TodolistdetailsController implements Initializable {

    @FXML
    private Label assignname;
    @FXML
    private TextArea assignText;

    /**
     * Initializes the controller class.
     */
    Todolist selectedModel;

    public void initData(Todolist model) throws IOException {
        selectedModel = model;
        assignname.setText(model.getAssignments().toString());
        //SOURCE: Professor Code
        StringBuffer buff = new StringBuffer();
        String TextFile = "/resource/text/" + model.getAssignments()+ ".txt";
        try (InputStreamReader input = new InputStreamReader(getClass().getResourceAsStream(TextFile))) {
            int data = input.read();
            while (data != -1) {
                buff.append((char) data);
                data = input.read();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        assignText.setText(buff.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    Scene previousScene;
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
    }

}
