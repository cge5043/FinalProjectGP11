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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Student;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class StudentDetailController implements Initializable {

    @FXML
    private ImageView profile;
    @FXML
    private Label firstname;
    @FXML
    private Label studentid;
    @FXML
    private Label lastname;
    @FXML
    private Label major;

    /**
     * Initializes the controller class.
     */
    
    
    Student selectedModel;
       public void initData(Student model) {
        selectedModel = model;
        studentid.setText(model.getStudentid().toString());
         firstname.setText(model.getStudentfirstname());
        lastname.setText(model.getStudentlastname());
        major.setText(model.getStudentmajor());

        try {

            String imagename = "/resource/images/" + model.getStudentid()+ ".png";
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
