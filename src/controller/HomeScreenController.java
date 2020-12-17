/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class HomeScreenController implements Initializable {

    @FXML
    private Button logOutButton;
    @FXML
    private Button toDoListButton;
    @FXML
    private Button mailboxButton;
    @FXML
    private Button courseButton1;
    @FXML
    private Button groupMenuButton;
    @FXML
    private Button buttonstudent;
    @FXML
    private ImageView studentimage;
    @FXML
    private ImageView courseimage;
    @FXML
    private ImageView todolistimage;
    @FXML
    private ImageView groupimage;
    @FXML
    private ImageView mailboximage;

    /**
     * Initializes the controller class.
     */
    EntityManager manager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // TODO
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
    }
    Scene previousScene;

    public void setPreviousScene(Scene scene) {
        previousScene = scene;
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        System.out.println("Hello");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LoginView.fxml"));

        Parent HomeLoader = loader.load();
        Scene tableViewScene = new Scene(HomeLoader);

        LoginMenuController home = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        home.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }

    @FXML
    private void showToDoList(ActionEvent event) throws IOException {
        System.out.println("clicked");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ToDoList.fxml"));

        Parent toDoListModelView = loader.load();
        Scene tableViewScene = new Scene(toDoListModelView);

        ToDoListController toDolistControlled = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        toDolistControlled.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }

    @FXML
    private void openMailbox(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MailboxMenuView.fxml"));

        Parent HomeLoader = loader.load();
        Scene tableViewScene = new Scene(HomeLoader);

        MailboxMenuController home = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        home.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }

    @FXML
    private void showCourses(ActionEvent event) throws IOException {
        System.out.println("clicked");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CourseMenuView.fxml"));

        Parent CourseMenuView = loader.load();
        Scene tableViewScene = new Scene(CourseMenuView);

        CourseMenuController CourseMenuControlled = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        CourseMenuControlled.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }

    @FXML
    private void showGroupMenu(ActionEvent event) throws IOException {
        System.out.println("clicked");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GroupMenuView.fxml"));

        Parent homeLoader = loader.load();
        Scene tableViewScene = new Scene(homeLoader);

        GroupMenuController home = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        home.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }

    @FXML
    private void studentview(ActionEvent event) throws IOException {
        System.out.println("clicked");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StudentMenuView.fxml"));

        Parent StudentMenuLoader = loader.load();
        Scene tableViewScene = new Scene(StudentMenuLoader);

        StudentMenuController student = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        student.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }

}
