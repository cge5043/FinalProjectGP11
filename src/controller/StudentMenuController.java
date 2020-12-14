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
import java.util.Scanner;
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
import model.Student;

/**
 *
 * @author a9512
 */
public class StudentMenuController implements Initializable {

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
    private Button searchByMajor;

    @FXML
    private Button searchByLast;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<Student> CourseTable;

    @FXML
    private TableColumn<Student, Integer> idColum;

    @FXML
    private TableColumn<Student, String> firstnameColum;

    @FXML
    private TableColumn<Student, String> lastnameColum;

    @FXML
    private TableColumn<Student, String> majorColum;

    @FXML
    private TableColumn<Student, String> courseColum1;

    @FXML
    private TableColumn<Student, String> courseColum2;

    @FXML
    private TableColumn<Student, String> courseColum3;

    @FXML
    private TableColumn<Student, String> courseColum4;

    @FXML
    private TableColumn<Student, String> courseColum5;

    @FXML
    private TableColumn<Student, String> courseColum6;

    @FXML
    private TableColumn<Student, String> courseColum7;

    @FXML
    private TableColumn<Student, String> courseColum8;

    @FXML
    private TableColumn<Student, String> courseColum9;

    @FXML
    private TableColumn<Student, String> courseColum10;

    @FXML
    private TextField searchBar;

    @FXML
    private TextField majorBar;

    @FXML
    private TextField lastBar;

    @FXML
    private Button showDetail;
    
    @FXML
    private Button courseButton1;
    
    @FXML
    private Button logOutButton;
    
    @FXML
    private Button mailboxButton;
    
    @FXML
    private Button toDoListButton;

    @FXML
    void createStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/createStudent.fxml"));

        Parent createStudentLoader = loader.load();
        Scene tableViewScene = new Scene(createStudentLoader);

        CreateStudentController studentCreation = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        studentCreation.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();

    }

    @FXML
    void searchByMaj(ActionEvent event) {
        //source:Demo code
        System.out.println("clicked");

        String studentMajor = majorBar.getText();

        List<Student> students = readByStudentMajor(studentMajor);

        if (students == null || students.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Student Found");
            alert.showAndWait();
        } else {

            setTableData(students);
        }
    }

    public List<Student> readByStudentMajor(String major) {
        Query query = manager.createNamedQuery("Student.findByStudentmajor");

        query.setParameter("studentmajor", major);

        List<Student> students = query.getResultList();
        for (Student s : students) {
            System.out.println(s.getStudentid() + " " + s.getStudentfirstname() + " " + s.getStudentlastname() + " " + s.getStudentmajor() + " " + s.getStudentcourse1() + " " + s.getStudentcourse2()
                    + " " + s.getStudentcourse3() + " " + s.getStudentcourse4() + " " + s.getStudentcourse5() + " " + s.getStudentcourse6() + " " + s.getStudentcourse7() + " " + s.getStudentcourse8() + " " + s.getStudentcourse9()
                    + " " + s.getStudentcourse10());
        }

        return students;
    }

    @FXML
    void searchByLastName(ActionEvent event) {
        //source:Demo code
        System.out.println("clicked");

        String studentLastName = lastBar.getText();

        List<Student> students = readByStudentLastName(studentLastName);

        if (students == null || students.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Student Found");
            alert.showAndWait();
        } else {

            setTableData(students);
        }

    }

    public List<Student> readByStudentLastName(String last) {
        Query query = manager.createNamedQuery("Student.findByStudentlastname");

        query.setParameter("studentlastname", last);

        List<Student> students = query.getResultList();
        for (Student s : students) {
            System.out.println(s.getStudentid() + " " + s.getStudentfirstname() + " " + s.getStudentlastname() + " " + s.getStudentmajor() + " " + s.getStudentcourse1() + " " + s.getStudentcourse2()
                    + " " + s.getStudentcourse3() + " " + s.getStudentcourse4() + " " + s.getStudentcourse5() + " " + s.getStudentcourse6() + " " + s.getStudentcourse7() + " " + s.getStudentcourse8() + " " + s.getStudentcourse9()
                    + " " + s.getStudentcourse10());
        }

        return students;
    }

    @FXML
    void readStudent(ActionEvent event) {
        //source:demo code
        Query query = manager.createNamedQuery("Student.findAll");
        List<Student> data = query.getResultList();

        for (Student s : data) {
            System.out.println(s.getStudentid() + " " + s.getStudentfirstname() + " " + s.getStudentlastname() + " " + s.getStudentmajor() + " " + s.getStudentcourse1() + " " + s.getStudentcourse2()
                    + " " + s.getStudentcourse3() + " " + s.getStudentcourse4() + " " + s.getStudentcourse5() + " " + s.getStudentcourse6() + " " + s.getStudentcourse7() + " " + s.getStudentcourse8() + " " + s.getStudentcourse9()
                    + " " + s.getStudentcourse10());
        }
        setTableData(data);
    }

    //Source: Demo Code
    private ObservableList<Student> studentData;

    public void setTableData(List<Student> todolist) {

        studentData = FXCollections.observableArrayList();

        todolist.forEach(s -> {
            studentData.add(s);
        });
        CourseTable.setItems(studentData);
        CourseTable.refresh();
    }

    @FXML
    void searchButton1(ActionEvent event) {
        //source: demo code
        System.out.println("clicked");

        String studentid = searchBar.getText();
        int studentidtoint = Integer.parseInt(studentid);
        int integerid = studentidtoint;

        List<Student> students = readByStudentid(integerid);

        if (students == null || students.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Student Found");
            alert.showAndWait();
        } else {

            setTableData(students);
        }

    }

    //source:demo code
    public List<Student> readByStudentid(Integer id) {
        Query query = manager.createNamedQuery("Student.findByStudentid");

        query.setParameter("studentid", id);

        List<Student> students = query.getResultList();
        for (Student s : students) {
            System.out.println(s.getStudentid() + " " + s.getStudentfirstname() + " " + s.getStudentlastname() + " " + s.getStudentmajor() + " " + s.getStudentcourse1() + " " + s.getStudentcourse2()
                    + " " + s.getStudentcourse3() + " " + s.getStudentcourse4() + " " + s.getStudentcourse5() + " " + s.getStudentcourse6() + " " + s.getStudentcourse7() + " " + s.getStudentcourse8() + " " + s.getStudentcourse9()
                    + " " + s.getStudentcourse10());
        }

        return students;
    }

    @FXML
    void showDetailButton(ActionEvent event) throws IOException {
         //Source: Demo Code  
        Student selectedAssignment = CourseTable.getSelectionModel().getSelectedItem();
        if(selectedAssignment==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error Information");
            alert.setHeaderText("Student Not Selected");
            alert.setContentText("Please Select a Student");
            alert.showAndWait(); 
        }
        else{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/studentDetail.fxml"));

        Parent todolistdetails = loader.load();
      
        Scene textViewScene = new Scene(todolistdetails);
      
        StudentDetailController detailedControlled = loader.getController();

        detailedControlled.initData(selectedAssignment);
   
        Stage stage = new Stage();
        stage.setScene(textViewScene);
        stage.show();
        }

    }

    @FXML
    void updateStudent(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/updateStudents.fxml"));

        Parent updateStudentLoader = loader.load();
        Scene tableViewScene = new Scene(updateStudentLoader);

        UpdateStudentsController studentUpdate = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        studentUpdate.setPreviousScene(currentScene);

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
        idColum.setCellValueFactory(new PropertyValueFactory<>("studentid"));
        firstnameColum.setCellValueFactory(new PropertyValueFactory<>("studentfirstname"));
        lastnameColum.setCellValueFactory(new PropertyValueFactory<>("studentlastname"));
        majorColum.setCellValueFactory(new PropertyValueFactory<>("studentmajor"));
        courseColum1.setCellValueFactory(new PropertyValueFactory<>("studentcourse1"));
        courseColum2.setCellValueFactory(new PropertyValueFactory<>("studentcourse2"));
        courseColum3.setCellValueFactory(new PropertyValueFactory<>("studentcourse3"));
        courseColum4.setCellValueFactory(new PropertyValueFactory<>("studentcourse4"));
        courseColum5.setCellValueFactory(new PropertyValueFactory<>("studentcourse5"));
        courseColum6.setCellValueFactory(new PropertyValueFactory<>("studentcourse6"));
        courseColum7.setCellValueFactory(new PropertyValueFactory<>("studentcourse7"));
        courseColum8.setCellValueFactory(new PropertyValueFactory<>("studentcourse8"));
        courseColum9.setCellValueFactory(new PropertyValueFactory<>("studentcourse9"));
        courseColum10.setCellValueFactory(new PropertyValueFactory<>("studentcourse10"));

        CourseTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    
    Scene previousScene;
    public void setPreviousScene(Scene scene) {
        previousScene = scene;
    }
    
        @FXML
    void logOut(ActionEvent event) throws IOException {
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
    void openMailbox(ActionEvent event) throws IOException {
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
    void showToDoList(ActionEvent event) throws IOException {
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
    void showCourses(ActionEvent event) throws IOException {
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

}
