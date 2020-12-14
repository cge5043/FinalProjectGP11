/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Professor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class ProfessorDetailController implements Initializable {

    @FXML
    private ImageView profile;
    @FXML
    private Label firstname;
    @FXML
    private Label professorid;
    @FXML
    private Label lastname;
    @FXML
    private Label department;

    /**
     * Initializes the controller class.
     */
    
    Professor selectedModel;
       public void initData(Professor model) {
        selectedModel = model;
        professorid.setText(model.getProfessorid().toString());
         firstname.setText(model.getProfessorfirstname());
        lastname.setText(model.getProfessorlastname());
        department.setText(model.getDepartment());

        try {

            String imagename = "/resource/images/" + model.getProfessorid()+ ".png";
            Image profiles = new Image(getClass().getResourceAsStream(imagename));
            profile.setImage(profiles);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
