/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Todolist;

/**
 *
 * @author a9512
 */
public class ToDoListController implements Initializable {
    
        @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="todolistTable"
    private TableView<Todolist> todolistTable; // Value injected by FXMLLoader

    @FXML // fx:id="idColum"
    private TableColumn<Todolist, String> idColum; // Value injected by FXMLLoader

    @FXML // fx:id="DueColum"
    private TableColumn<Todolist, String> DueColum; // Value injected by FXMLLoader

    @FXML // fx:id="AssignmentColum"
    private TableColumn<Todolist, String> AssignmentColum; // Value injected by FXMLLoader

    @FXML // fx:id="showAssign"
    private Button showAssign; // Value injected by FXMLLoader

    @FXML // fx:id="searchBar"
    private TextField searchBar; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader
    
    @FXML
    private Button assigndetail;

    @FXML
    void searchButton1(ActionEvent event) {
        //source: demo code
        System.out.println("clicked");
       
        String courseid = searchBar.getText();

    
        List<Todolist> todolists = readByCourseid(courseid);

     
        if (todolists == null || todolists.isEmpty()) {

           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Course Found");
            alert.showAndWait(); 
        } else {
           
            setTableData(todolists);
        }

    }

    @FXML
    void showAll(ActionEvent event) {
        //source:demo code
         Query query = manager.createNamedQuery("Todolist.findAll");
        List<Todolist> data = query.getResultList();

        for (Todolist t : data) {
            System.out.println(t.getCourseid() + " " + t.getDuedate() + " " + t.getAssignments());
        }
        setTableData(data);
    }
    
    //Source: Demo Code
        private ObservableList<Todolist> todolistData;

    
    public void setTableData(List<Todolist> todolist) {

        
        todolistData = FXCollections.observableArrayList();

        
        todolist.forEach(t -> {
            todolistData.add(t);
        });
        todolistTable.setItems(todolistData);
        todolistTable.refresh();
    }
    
    @FXML
    void showdetails(ActionEvent event) throws IOException {
        //Source: Demo Code  
        Todolist selectedAssignment = todolistTable.getSelectionModel().getSelectedItem();
        if(selectedAssignment==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Information");
            alert.setHeaderText("Course Not Selected");
            alert.setContentText("Please Select a Course");
            alert.showAndWait(); 
        }
        else{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/todolistdetails.fxml"));

        Parent todolistdetails = loader.load();
      
        Scene textViewScene = new Scene(todolistdetails);
      
        TodolistdetailsController detailedControlled = loader.getController();

        detailedControlled.initData(selectedAssignment);
   
        Stage stage = new Stage();
        stage.setScene(textViewScene);
        stage.show();
        }
    }
    

    EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         //Source:Demo Code
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
        
        //Source: Demo Code
         DueColum.setCellValueFactory(new PropertyValueFactory<>("duedate"));
        idColum.setCellValueFactory(new PropertyValueFactory<>("courseid"));
        AssignmentColum.setCellValueFactory(new PropertyValueFactory<>("assignments"));

        todolistTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }    
    //source:demo code
     public List<Todolist> readByCourseid(String id) {
        Query query = manager.createNamedQuery("Todolist.findByCourseid");


        query.setParameter("courseid", id);


        List<Todolist> todolists = query.getResultList();
        for (Todolist todolist : todolists) {
            System.out.println(todolist.getCourseid()+ " " + todolist.getDuedate()+ " " + todolist.getAssignments());
        }

        return todolists;
    }
    Scene previousScene;
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
    }
    
    
    @FXML
    private Button goback;
    
        @FXML
    void backbutton(ActionEvent event) throws IOException {
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
  
    
}
