/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Course;
import model.Professor;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class CreateCourseController implements Initializable {

    @FXML
    private TextField firstBar;
    @FXML
    private TextField LastBAR;
    @FXML
    private TextField departBar;
    @FXML
    private TextField professoridBar;
    @FXML
    private Button updateComplete;
    @FXML
    private Label studentlabel;
    @FXML
    private Label department;
    @FXML
    private Label lastname;
    @FXML
    private Label firstname;
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
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) {
        String id = professoridBar.getText();
        String name = firstBar.getText();
        String major = LastBAR.getText();
        String proname  = departBar.getText();
       

        try {
            int courseidtoint = Integer.parseInt(id);
            int integerid = courseidtoint;

        Course courses = new Course();
        
        courses.setId(integerid);
        courses.setName(name);
        courses.setMajor(major);
        courses.setProname(proname);   
        create(courses);

        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Dialog Box");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please Input Integer For Course ID");
            alert.showAndWait();
        }
        
        
    }
    
    
      //Source:Demo Code
public void create(Course courses) {
        try {
            manager.getTransaction().begin();
            
            if (courses.getId() != null) {
                
                manager.persist(courses);
                
                manager.getTransaction().commit();
                
                System.out.println(courses.toString() + " is created");
                System.out.println(courses.toString() + " is created");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Creation Dialog Box");
                alert.setContentText("Course Created");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register Dialog Box");
            alert.setHeaderText("Invalid Input or Course ID Exisit (Course ID can Only Be less than 10 Digits)");
            alert.setContentText("Please Re-enter an Course ID");
            alert.showAndWait();
            System.out.println("Invalid Input or Course ID Exsist");
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

    Course selectedModel;

    public void initData(Course model) {
        selectedModel = model;
    }

    }
    

