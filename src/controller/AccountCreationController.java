package controller;

import model.Login;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AccountCreationController implements Initializable {

    @FXML
    private TextField textboxUserName;

    @FXML
    private PasswordField textboxUserPassword;

    @FXML
    private Button backButton;
    @FXML
    private TextField textboxUserID;

    @FXML
    private Button CreateButton;

    @FXML
    void CreateButton(ActionEvent event) {

        //source demo code
        String createUserID = textboxUserID.getText();
        String createUserPassword = textboxUserPassword.getText();
        String createUserName = textboxUserName.getText();

        try {
            int useridtoint = Integer.parseInt(createUserID);
            int integerid = useridtoint;

            Login logins = new Login();

            logins.setUserid(integerid);
            logins.setPassword(createUserPassword);
            logins.setUsername(createUserName);

            create(logins);
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register Dialog Box");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please Input Integer For User ID");
            alert.showAndWait();
        }

    }

    public void create(Login logins) {
        //source:demo code     
        try {

            manager.getTransaction().begin();

            if (logins.getUserid() != null) {

                manager.persist(logins);

                manager.getTransaction().commit();

                System.out.println(logins.toString() + " is created");
            }

        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register Dialog Box");
            alert.setHeaderText("Invalid Input or User ID Exisit");
            alert.setContentText("Please Re-enter an User ID");
            alert.showAndWait();
            System.out.println("Invalid Input or User ID Exsist");
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    void backButton(ActionEvent event) {
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

    EntityManager manager;

    public void initialize(URL url, ResourceBundle rb) {
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
        // TODO
    }

}
