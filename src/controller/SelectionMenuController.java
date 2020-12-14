package controller;

import controller.ProfessorMenuController;
import controller.StudentMenuController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SelectionMenuController {

    @FXML
    private Button studentViewButton;

    @FXML
    private Button professorViewButton;

    @FXML
    void openProfessorView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ProfessorMenuView.fxml"));

        Parent HomeLoader = loader.load();
        Scene tableViewScene = new Scene(HomeLoader);

        ProfessorMenuController home = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        home.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show(); 
    }

    @FXML
    void openStudentView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StudentMenuView.fxml"));

        Parent HomeLoader = loader.load();
        Scene tableViewScene = new Scene(HomeLoader);

        StudentMenuController home = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        home.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show(); 
    }
    EntityManager manager;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
    }
    
    Scene previousScene;
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
    }
}
    
    

