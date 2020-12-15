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
public class CreateProfessorController implements Initializable {

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
    private Button createComplete;
    @FXML
    private Label studentlabel;
    @FXML
    private Label course2;
    @FXML
    private Label course1;
    @FXML
    private Label major;
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
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
    }

    @FXML
    private void create(ActionEvent event) {
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
            
            

            completeCreate(professors);
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Creation Dialog Box");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please Input Integer For Professor ID ");
            alert.showAndWait();
        }
    }

    public void completeCreate(Professor professors) {
        //source:demo code     
        try {

            manager.getTransaction().begin();

            if (professors.getProfessorid() != null) {

                manager.persist(professors);

                manager.getTransaction().commit();

                System.out.println(professors.toString() + " is created");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Creation Dialog Box");
                alert.setContentText("Professor Created");
                alert.showAndWait();
            }

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register Dialog Box");
            alert.setHeaderText("Invalid Input or Professor ID Exisit (Professor ID can Only Be less than 10 Digits)");
            alert.setContentText("Please Re-enter an Professor ID");
            alert.showAndWait();
            System.out.println("Invalid Input or Professor ID Exsist");
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    void backbutton(ActionEvent event) {
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
