/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Professor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class UpdateProfessorController implements Initializable {

    @FXML
    private TextField courseBar1;
    @FXML
    private TextField firstBar;
    @FXML
    private TextField LastBAR;
    @FXML
    private TextField departBar;
    @FXML
    private TextField courseBar5;
    @FXML
    private TextField professoridBar;
    @FXML
    private TextField courseBar2;
    @FXML
    private TextField courseBar3;
    @FXML
    private TextField courseBar4;
    @FXML
    private Button updateComplete;
    @FXML
    private Label studentlabel;
    @FXML
    private Label course2;
    @FXML
    private Label course1;
    @FXML
    private Label department;
    @FXML
    private Label lastname;
    @FXML
    private Label firstname;
    @FXML
    private Label course5;
    @FXML
    private Label course4;
    @FXML
    private Label course3;
    @FXML
    private Button goback;
    @FXML
    private Text createStudent1;

    /**
     * Initializes the controller class.
     */
    
      EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        manager = (EntityManager) Persistence.createEntityManagerFactory("ProfessorFxmlPU").createEntityManager();
    }    

    @FXML
    private void update(ActionEvent event) {
        //source demo code
        String createProfessorID = professoridBar.getText();
        String firstName = firstBar.getText();
        String lastName = LastBAR.getText();
        String department = departBar.getText();
        String course1 = courseBar1.getText();
        String course2 = courseBar2.getText();
        String course3 = courseBar3.getText();
        String course4 = courseBar4.getText();
        String course5 = courseBar5.getText();
        

        try {
            int professoridtoint = Integer.parseInt(createProfessorID);
            int integerid = professoridtoint;

            Professor professors = new Professor();

            professors.setProfessorid(professoridtoint);
            professors.setProfessorfirstname(firstName);
            professors.setProfessorlastname(lastName);
            professors.setDepartment(department);
            professors.setCourse1(course1);
            professors.setCourse2(course2);
            professors.setCourse3(course3);
            professors.setCourse4(course4);
            professors.setCourse5(course5);

            updateProfessor(professors);
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Dialog Box");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please Input Integer For Professor ID");
            alert.showAndWait();
        }
    }
    
      public void updateProfessor(Professor model) {
        try {

            Professor existingProfessor = manager.find(Professor.class, model.getProfessorid());

            if (existingProfessor != null) {

                manager.getTransaction().begin();
                
                existingProfessor.setProfessorfirstname(model.getProfessorfirstname());
                existingProfessor.setProfessorid(model.getProfessorid());
                existingProfessor.setProfessorlastname(model.getProfessorlastname());
                existingProfessor.setDepartment(model.getDepartment());
                existingProfessor.setCourse1(model.getCourse1());
                existingProfessor.setCourse2(model.getCourse2());
                existingProfessor.setCourse3(model.getCourse3());
                existingProfessor.setCourse4(model.getCourse4());
                existingProfessor.setCourse5(model.getCourse5());
                
         
                manager.getTransaction().commit();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Dialog Box");
                alert.setContentText("Update Complete");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Dialog Box");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Your Professor ID Does Not Found");
            alert.showAndWait();
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void backbutton(ActionEvent event) {
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (previousScene != null) {
            stage.setScene(previousScene);
        }
    }
    
    Scene previousScene;

    //Source: Demo Code
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        goback.setDisable(false);
    }

    Professor selectedModel;

    public void initData(Professor model) {
        selectedModel = model;
    }
  
}
