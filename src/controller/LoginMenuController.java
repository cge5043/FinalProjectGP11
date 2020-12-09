/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author a9512
 */
public class LoginMenuController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField IdBar;

    @FXML
    private TextField password;

    @FXML
    private Button loginButton;

    @FXML
    private Button createAccount;
    
    @FXML
    private TableView<Login> LoginTable;

    @FXML
    void createNew(ActionEvent event) throws IOException {
        System.out.println("clicked");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/accountcreation.fxml"));

        Parent accountCreationLoader = loader.load();
        Scene tableViewScene = new Scene(accountCreationLoader);

        AccountCreationController accountCreation = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        accountCreation.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }

    @FXML
    void login(ActionEvent event) {
            //source: demo code
        //String DBQ="Select * from Login where userid='"+IdBar.getText()+"' AND password= '"+password.getText()+"'";
       // ResultSet rs=query
        String userID = IdBar.getText();
        String userPassword=password.getText();
        
        // read input from command line
        
        
        // create a student instance      
        //List<Login> logins =  LoginAccount(userID, userPassword);
          if (userID.isEmpty() || userPassword.isEmpty()) {

           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Course Found");
            alert.showAndWait(); 
        } else {
             System.out.println("sett");
        
            LoginAccount(userID, userPassword);
        }

    }

     //source:demo code
     public void LoginAccount(String userID, String userPassword) {
        Query query = manager.createNamedQuery("Login.findByUseridAndPassword");
        // setting query parameter
        query.setParameter("userid", userID);
        query.setParameter("password", userPassword);
        
        
        // execute query
       // List<Login> logins =  query.getResultList();
     /*  if(query.getResultList().equals(userID)&&query.getResultList().equals(userPassword)){
           System.out.println("Login Success");
       }
       else{
        System.out.println("Login Failed");}*/

            if(userID.equals(query.getResultList())&&userPassword.equals(query.getResultList())){
                System.out.println("Login Success");
            }
            else{
                System.out.println("Login Failed");
            }
            


    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
        // TODO
    }    
    
}
