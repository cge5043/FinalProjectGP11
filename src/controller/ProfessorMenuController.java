/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Professor;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author a9512
 */
public class ProfessorMenuController implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createbutton;

    @FXML
    private Button readbutton;

    @FXML
    private Button updatebutton;

    @FXML
    private Button searchbydepart;

    @FXML
    private Button searchbylast;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<Professor> CourseTable;

    @FXML
    private TableColumn<Professor, Integer> idColum;

    @FXML
    private TableColumn<Professor, String> firstnameColum;

    @FXML
    private TableColumn<Professor, String> lastnameColum;

    @FXML
    private TableColumn<Professor, String> departColum;

    @FXML
    private TableColumn<Professor, String> courseColum1;

    @FXML
    private TableColumn<Professor, String> courseColum2;

    @FXML
    private TableColumn<Professor, String> courseColum3;

    @FXML
    private TableColumn<Professor, String> courseColum4;

    @FXML
    private TableColumn<Professor, String> courseColum5;

    @FXML
    private TextField searchBar;

    @FXML
    private Button showDetail;

    @FXML
    private TextField searchBar1;

    @FXML
    private TextField searchBar2;

    @FXML
    void createProfessor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/createProfessor.fxml"));

        Parent createProfessorLoader = loader.load();
        Scene tableViewScene = new Scene(createProfessorLoader);

        CreateProfessorController professorCreation = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        professorCreation.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }

    @FXML
    void searchByLastName(ActionEvent event) {
        //source:Demo code
        System.out.println("clicked");

        String professorLast = searchBar1.getText();

        List<Professor> professors = readByProfessorLast(professorLast);

        if (professors == null || professors.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Professor Found");
            alert.showAndWait();
        } else {

            setTableData(professors);
        }
        
    }
    
     public List<Professor> readByProfessorLast(String lastname) {
        Query query = manager.createNamedQuery("Professor.findByProfessorlastname");

        query.setParameter("professorlastname", lastname);

        List<Professor> professors = query.getResultList();
        for (Professor p : professors) {
            System.out.println(p.getProfessorid() + " " +p.getProfessorfirstname()+ " " + p.getProfessorlastname() + " " +p.getDepartment() + " " + p.getCourse1() + " " + p.getCourse2()
                    + " " + p.getCourse3() + " " + p.getCourse4() + " " + p.getCourse5());
        }

        return professors;
    }
    
    
    

    @FXML
    void searchBydepart(ActionEvent event) {
        //source:Demo code
        System.out.println("clicked");

        String professorDepart = searchBar2.getText();

        List<Professor> professors = readByProfessorDepart(professorDepart);

        if (professors == null || professors.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Professor Found");
            alert.showAndWait();
        } else {

            setTableData(professors);
        }

    }
    
      //Source: Demo Code
    private ObservableList<Professor> professorData;

    public void setTableData(List<Professor> todolist) {

        professorData = FXCollections.observableArrayList();

        todolist.forEach(s -> {
            professorData.add(s);
        });
        CourseTable.setItems(professorData);
        CourseTable.refresh();
    }
    
     public List<Professor> readByProfessorDepart(String department) {
        Query query = manager.createNamedQuery("Professor.findByDepartment");

        query.setParameter("department", department);

        List<Professor> professors = query.getResultList();
        for (Professor p : professors) {
            System.out.println(p.getProfessorid() + " " +p.getProfessorfirstname()+ " " + p.getProfessorlastname() + " " +p.getDepartment() + " " + p.getCourse1() + " " + p.getCourse2()
                    + " " + p.getCourse3() + " " + p.getCourse4() + " " + p.getCourse5());
        }

        return professors;
    }

    @FXML
    void readProfessor(ActionEvent event) {
        //source:demo code
        Query query = manager.createNamedQuery("Professor.findAll");
        List<Professor> data = query.getResultList();

        for (Professor p : data) {
             System.out.println(p.getProfessorid() + " " +p.getProfessorfirstname()+ " " + p.getProfessorlastname() + " " +p.getDepartment() + " " + p.getCourse1() + " " + p.getCourse2()
                    + " " + p.getCourse3() + " " + p.getCourse4() + " " + p.getCourse5());
        }
        setTableData(data);

    }
    

    @FXML
    void searchButton1(ActionEvent event) {
        //source:Demo code
        System.out.println("clicked");

        String professorID = searchBar.getText();
         int professoridtoint = Integer.parseInt(professorID);
        int integerid = professoridtoint;

        List<Professor> professors = readByProfessorID(integerid);

        if (professors == null || professors.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Professor Found");
            alert.showAndWait();
        } else {

            setTableData(professors);
        }
        

    }
    
    
    
     public List<Professor> readByProfessorID(Integer id) {
        Query query = manager.createNamedQuery("Professor.findByProfessorid");

        query.setParameter("professorid", id);

        List<Professor> professors = query.getResultList();
        for (Professor p : professors) {
            System.out.println(p.getProfessorid() + " " +p.getProfessorfirstname()+ " " + p.getProfessorlastname() + " " +p.getDepartment() + " " + p.getCourse1() + " " + p.getCourse2()
                    + " " + p.getCourse3() + " " + p.getCourse4() + " " + p.getCourse5());
        }

        return professors;
    }
    
    
    
    

    @FXML
    void showDetailButton(ActionEvent event) throws IOException {
        
          //Source: Demo Code  
        Professor selectedAssignment = CourseTable.getSelectionModel().getSelectedItem();
        if(selectedAssignment==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Information");
            alert.setHeaderText("Professor Not Selected");
            alert.setContentText("Please Select a Professor");
            alert.showAndWait(); 
        }
        else{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/professorDetail.fxml"));

        Parent professordetails = loader.load();
      
        Scene textViewScene = new Scene(professordetails);
      
        ProfessorDetailController detailedControlled = loader.getController();

        detailedControlled.initData(selectedAssignment);
   
        Stage stage = new Stage();
        stage.setScene(textViewScene);
        stage.show();
        }

    }

    @FXML
    void updateProfessor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/updateProfessor.fxml"));

        Parent updateProfessorLoader = loader.load();
        Scene tableViewScene = new Scene(updateProfessorLoader);

        UpdateProfessorController professorUpdate = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        professorUpdate.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
     EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
          //Source: Demo Code    
        idColum.setCellValueFactory(new PropertyValueFactory<>("professorid"));
        firstnameColum.setCellValueFactory(new PropertyValueFactory<>("professorfirstname"));
        lastnameColum.setCellValueFactory(new PropertyValueFactory<>("professorlastname"));
        departColum.setCellValueFactory(new PropertyValueFactory<>("department"));
        courseColum1.setCellValueFactory(new PropertyValueFactory<>("course1"));
        courseColum2.setCellValueFactory(new PropertyValueFactory<>("course2"));
        courseColum3.setCellValueFactory(new PropertyValueFactory<>("course3"));
        courseColum4.setCellValueFactory(new PropertyValueFactory<>("course4"));
        courseColum5.setCellValueFactory(new PropertyValueFactory<>("course5"));

        CourseTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    
      Scene previousScene;
    public void setPreviousScene(Scene scene) {
        Scene previousScene = scene;
        //backButton.setDisable(false);
    }
    
    
    @FXML
    private Button logOutButton;
    
    @FXML
    void logOut(ActionEvent event) throws IOException {
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
    
}
