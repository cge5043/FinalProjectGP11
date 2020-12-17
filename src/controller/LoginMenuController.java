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
import javafx.scene.control.PasswordField;
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
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Button createAccount;

    @FXML
    void createNew(ActionEvent event) throws IOException {
        System.out.println("clicked");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/accountcreation.fxml"));

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
    void login(ActionEvent event) throws IOException {
        //source: demo code
        String userID = IdBar.getText();
        String userPassword = password.getText();

        boolean loginStatus = false;
        if (userID.isEmpty() || userPassword.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Dialog Box");
            alert.setHeaderText("Login Failed");
            alert.setContentText("No Password or ID Found");
            alert.showAndWait();
        } else {
            // System.out.println("error");

            loginStatus = LoginAccount(userID, userPassword);

        }
        if (loginStatus == true) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SelectionMenuView.fxml"));

            Parent HomeLoader = loader.load();
            Scene tableViewScene = new Scene(HomeLoader);

            SelectionMenuController home = loader.getController();

            Scene currentScene = ((Node) event.getSource()).getScene();
            home.setPreviousScene(currentScene);

            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(tableViewScene);
            stage.show();

        }

    }

    //source:demo code
    public boolean LoginAccount(String userID, String userPassword) {
        try {
            Query query = manager.createNamedQuery("Login.findByUseridAndPassword");
            // setting query parameter

            query.setParameter("userid", Integer.parseInt(userID));
            query.setParameter("password", userPassword);

            Login logins = (Login) query.getSingleResult();
            System.out.println("Login Success");
            return true;

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Dialog Box");
            alert.setHeaderText("Login Failed");
            alert.setContentText("No Password or ID Found");
            alert.showAndWait();
            System.out.println("Login Failed");
            return false;
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

    Scene previousScene;

    //Source: Demo Code
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
    }

}
