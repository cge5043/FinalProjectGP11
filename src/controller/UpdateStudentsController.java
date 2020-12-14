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
import model.Student;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class UpdateStudentsController implements Initializable {

    @FXML
    private TextField courseBar1;
    @FXML
    private TextField firstBar;
    @FXML
    private TextField LastBAR;
    @FXML
    private TextField majorBar;
    @FXML
    private TextField courseBar9;
    @FXML
    private TextField courseBar8;
    @FXML
    private TextField courseBar7;
    @FXML
    private TextField courseBar6;
    @FXML
    private TextField courseBar5;
    @FXML
    private TextField courseBar10;
    @FXML
    private TextField studentidBar;
    @FXML
    private TextField courseBar2;
    @FXML
    private TextField courseBar3;
    @FXML
    private TextField courseBar4;
    @FXML
    private Text updateStudent;
    @FXML
    private Button updateComplete;
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
    private Label course10;
    @FXML
    private Label course9;
    @FXML
    private Label course8;
    @FXML
    private Label course7;
    @FXML
    private Label course6;
    @FXML
    private Label course5;
    @FXML
    private Label course4;
    @FXML
    private Label course3;
    @FXML
    private Button goback;

    /**
     * Initializes the controller class.
     */
    EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
    }    

    @FXML
    private void update(ActionEvent event) {
        //source demo code
        String createStudentID = studentidBar.getText();
        String firstName = firstBar.getText();
        String lastName = LastBAR.getText();
        String major = majorBar.getText();
        String course1 = courseBar1.getText();
        String course2 = courseBar2.getText();
        String course3 = courseBar3.getText();
        String course4 = courseBar4.getText();
        String course5 = courseBar5.getText();
        String course6 = courseBar6.getText();
        String course7 = courseBar7.getText();
        String course8 = courseBar8.getText();
        String course9 = courseBar9.getText();
        String course10 = courseBar10.getText();

        try {
            int studentidtoint = Integer.parseInt(createStudentID);
            int integerid = studentidtoint;

            Student students = new Student();

            students.setStudentid(integerid);
            students.setStudentfirstname(firstName);
            students.setStudentlastname(lastName);
            students.setStudentmajor(major);
            students.setStudentcourse1(course1);
            students.setStudentcourse2(course2);
            students.setStudentcourse3(course3);
            students.setStudentcourse4(course4);
            students.setStudentcourse5(course5);
            students.setStudentcourse6(course6);
            students.setStudentcourse7(course7);
            students.setStudentcourse8(course8);
            students.setStudentcourse9(course9);
            students.setStudentcourse10(course10);

            updateStudent(students);
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Dialog Box");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please Input Integer For Student ID (Student ID can Only Be less than 10 Digits)");
            alert.showAndWait();
        }
    }
    
      public void updateStudent(Student model) {
        try {

            Student existingStudent = manager.find(Student.class, model.getStudentid());

            if (existingStudent != null) {

                manager.getTransaction().begin();
                
                existingStudent.setStudentfirstname(model.getStudentfirstname());
                existingStudent.setStudentlastname(model.getStudentlastname());
                existingStudent.setStudentmajor(model.getStudentmajor());
                existingStudent.setStudentcourse1(model.getStudentcourse1());
                existingStudent.setStudentcourse2(model.getStudentcourse2());
                existingStudent.setStudentcourse3(model.getStudentcourse3());
                existingStudent.setStudentcourse4(model.getStudentcourse4());
                existingStudent.setStudentcourse5(model.getStudentcourse5());
                existingStudent.setStudentcourse6(model.getStudentcourse6());
                existingStudent.setStudentcourse7(model.getStudentcourse7());
                existingStudent.setStudentcourse8(model.getStudentcourse8());
                existingStudent.setStudentcourse9(model.getStudentcourse9());
                existingStudent.setStudentcourse10(model.getStudentcourse10());
                
         
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
            alert.setContentText("Your Student ID Does Not Found");
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

    Student selectedModel;

    public void initData(Student model) {
        selectedModel = model;
    }

}
