/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Groups;
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
public class CreateGroupController implements Initializable {

    @FXML
    private TextField member2Bar;
    @FXML
    private TextField GroupNameBar;
    @FXML
    private TextField CourseBAR;
    @FXML
    private TextField member1Bar;
    @FXML
    private TextField member10Bar;
    @FXML
    private TextField member9Bar;
    @FXML
    private TextField member8Bar;
    @FXML
    private TextField member7Bar;
    @FXML
    private TextField member6Bar;
    @FXML
    private TextField GroupidBar;
    @FXML
    private TextField member3Bar;
    @FXML
    private TextField member4Bar;
    @FXML
    private TextField member5Bar;
    @FXML
    private Text updateGroup;
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
        // TODO
    }    

// Create button, take it from update view
    @FXML
    private void update(ActionEvent event) {
        String createGroupID = GroupidBar.getText();
        String GroupName = GroupNameBar.getText();
        String Course = CourseBAR.getText();
        String member1 = member1Bar.getText();
        String member2 = member2Bar.getText();
        String member3 = member3Bar.getText();
        String member4 = member4Bar.getText();
        String member5 = member5Bar.getText();
        String member6 = member6Bar.getText();
        String member7 = member7Bar.getText();
        String member8 = member8Bar.getText();
        String member9= member9Bar.getText();
        String member10 = member10Bar.getText();
        
         try {
            int groupidtoint = Integer.parseInt(createGroupID);
            int integerid = groupidtoint;

            Groups groups = new Groups();

            groups.setGroupid(groupidtoint);
            groups.setGroupname(GroupName);
            groups.setCourseattribute(Course);
            groups.setMember1(member1);
            groups.setMember2(member2);
            groups.setMember3(member3);
            groups.setMember4(member4);
            groups.setMember5(member5);
            groups.setMember6(member6);
            groups.setMember7(member7);
            groups.setMember8(member8);
            groups.setMember9(member9);
            groups.setMember10(member10);
                  completeCreate(groups);
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Creation Dialog Box");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please Input Integer For Group ID (Group ID can Only Be less than 10 Digits)");
            alert.showAndWait();
        }

    }
    
     public void completeCreate(Groups groups) {
        //source:demo code     
        try {

            manager.getTransaction().begin();

            if (groups.getGroupid() != null) {

                manager.persist(groups);

                manager.getTransaction().commit();

                System.out.println(groups.toString() + " is created");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Creation Dialog Box");
                alert.setContentText("Group Created");
                alert.showAndWait();
            }

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register Dialog Box");
            alert.setHeaderText("Invalid Input or Group ID Exisit (Group ID can Only Be less than 10 Digits)");
            alert.setContentText("Please Re-enter an Group ID");
            alert.showAndWait();
            System.out.println("Invalid Input or Group ID Exsist");
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

    Groups selectedModel;

    public void initData(Groups model) {
        selectedModel = model;
    }
    }
    

