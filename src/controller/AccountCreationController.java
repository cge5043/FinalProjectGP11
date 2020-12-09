package controller;

import model.Login;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AccountCreationController {

    @FXML
    private TextField textboxUserName;

    @FXML
    private PasswordField textboxUserPassword;

    @FXML
    private Button backButton;

    @FXML
    void backButton1(ActionEvent event) {
        //Source:Demo Code
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
        if (previousScene != null) {
            stage.setScene(previousScene);
        }
    }
    
    Scene previousScene;
    //Source: Demo Code
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
        backButton.setDisable(false);
    }
    
    Login selectedModel;
    public void initData(Login model) {
        selectedModel = model;
    }
 
}
