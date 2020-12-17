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
import javafx.scene.control.Alert.AlertType;
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
import model.Course;


/**
 *
 * @author a9512
 */
public class CourseMenuController implements Initializable {
    //Start of Course
    @FXML
    private Label label;
    @FXML
    private Button createbutton;

    @FXML
    private Button readbutton;

    @FXML
    private Button updatebutton;

    @FXML
    private Button deletebutton;
    
    @FXML
    private Button readbyidbutton;

    @FXML
    private Button readbymabutton;
    
    @FXML
    private Button searchButton;
     
    @FXML
    private TableView<Course> CourseTable;

    @FXML
    private TableColumn<Course, Integer> idColum;

    @FXML
    private TableColumn<Course, String> CourseColum;

    @FXML
    private TableColumn<Course, String> majorColum;

    @FXML
    private TableColumn<Course, String> pronameColum;
    
    @FXML
    private TextField searchBar;

    @FXML
    private Button advancedSearch; 
    @FXML
    private Button showDetail;
    @FXML
    private Button showDetailwindow;

    

   // show course detail in one window
    @FXML
    void showDetailPlace(ActionEvent event) throws IOException {
        System.out.println("clicked");

        //Source: Demo Code
        Course selectedCourse= CourseTable.getSelectionModel().getSelectedItem();

        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DetailedModelView.fxml"));

        Parent detailedModelView = loader.load();

        Scene tableViewScene = new Scene(detailedModelView);

        DetailedModelViewController detailedControlled = loader.getController();


        detailedControlled.initData(selectedCourse);

        Scene currentScene = ((Node) event.getSource()).getScene();
        detailedControlled.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }

    //show detail with pop up window
     @FXML
    void showDetailButton(ActionEvent event) throws IOException {
       System.out.println("clicked");

      //Source: Demo Code  
        
        Course selectedCourse = CourseTable.getSelectionModel().getSelectedItem();
        
       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DetailedModelView.fxml"));

        
        Parent DetailedModelView = loader.load();

      
        Scene tableViewScene = new Scene(DetailedModelView);

      
        DetailedModelViewController detailedControlled = loader.getController();


        detailedControlled.initData(selectedCourse);

   
        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();
    }

    // course advance search
     @FXML
    void advancedSearch1(ActionEvent event) {
        //source: demo code
        System.out.println("clicked");
       
        String name = searchBar.getText();

    
        List<Course> courses = readByCourseAdvanced(name);

     
        if (courses == null || courses.isEmpty()) {

           
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Course Found");
            alert.showAndWait(); 
        } else {
           
            setTableData(courses);
        }
    }

//Source: Demo Code
    private ObservableList<Course> courseData;

    
    public void setTableData(List<Course> courseList) {

        
        courseData = FXCollections.observableArrayList();

        
        courseList.forEach(c -> {
            courseData.add(c);
        });

        
        CourseTable.setItems(courseData);
        CourseTable.refresh();
    }
    
//Source:Demo Code
    //create course
    @FXML
    void createCourse(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/createCourse.fxml"));

        Parent createCourseLoader = loader.load();
        Scene tableViewScene = new Scene(createCourseLoader);

        CreateCourseController courseCreate = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        courseCreate.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
        
        
        
        
        
        
     
    }
//source: demo code
    //delete course
    @FXML
    void deleteCourse(ActionEvent event) {
         Course selectedCourse = CourseTable.getSelectionModel().getSelectedItem();

        initData(selectedCourse);
        

    }
      // delete end
    Course selectedModel;
// get selected model's id
    public void initData(Course model) {
        selectedModel = model;
        int id = model.getId();
        Course courses = deleteById(id);
        delete(courses);

    }
    //code end
    
    
    //source: demo code
    //delete course operation
public Course deleteById(int id){
        Query query = manager.createNamedQuery("Course.findById");
        
        query.setParameter("id", id);
        
        Course courses = (Course) query.getSingleResult();
        if (courses != null) {
            System.out.println(courses.getId() + " " + courses.getName() + " " + courses.getMajor()+" "+courses.getProname());
        }
        
        return courses;
    }        


    //Source:Demo Code
//read all course
    @FXML
    void readCourse(ActionEvent event) {
        Query query = manager.createNamedQuery("Course.findAll");
        List<Course> courses = query.getResultList();

        for (Course s : courses) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getMajor()+" "+s.getProname());
        }
         setTableData(courses);
        
    }
    //source:demo code
    //update course
    @FXML
    void updateCourse(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/courseUpdate.fxml"));

        Parent updateCourseLoader = loader.load();
        Scene tableViewScene = new Scene(updateCourseLoader);

        CourseUpdateController courseUpdate = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        courseUpdate.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();

        
        
    }
    
  
    
    //Source: demo code
    // search course by id
     @FXML
    void readByID(ActionEvent event) {
       //Scanner input = new Scanner(System.in);
        
      //  System.out.println("Enter Course ID:");
        
        
       // int id = input.nextInt();
        
        
        String courseid = searchBar.getText();
        int courseidtoint = Integer.parseInt(courseid);
        int integerid = courseidtoint;
        List<Course> s = readById(integerid);
        
         if (s == null || s.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Course Found");
            alert.showAndWait(); 
        } 
        else {
            setTableData(s);
        }
       // Course s = readById(id);
        System.out.println(s.toString());
    }
    // code end
    
    //source: demo code
    //search course by major
    @FXML
    void readByMajor(ActionEvent event) {
       // Scanner input = new Scanner(System.in);
        
      //  System.out.println("Enter Major:");
      //  String major = input.next();
        String major = searchBar.getText();
        List<Course> s = readByMajor(major);
         if (s == null || s.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Course Found");
            alert.showAndWait(); 
        } 
        else {
            setTableData(s);
        }
        System.out.println(s.toString());
    }
    //code end
    //search course by course name
     @FXML
    void searchButton1(ActionEvent event) {
        System.out.println("Clicked");
        //Source: Demo Code     
        String name = searchBar.getText();
        List<Course> courses = readByCourse(name);
        if (courses == null || courses.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Course Found");
            alert.showAndWait(); 
        } 
        else {
            setTableData(courses);
        }
    }
    //code end
    //Source:Demo Code
  
    
    //source: demo code
    //readby id operation
    public List<Course> readById(int id){
        Query query = manager.createNamedQuery("Course.findById");
        query.setParameter("id", id);
        List<Course> courses = query.getResultList();
       for (Course s : courses) {
            System.out.println(s.getId() + " " + s.getName() + " " + s.getMajor()+" "+s.getProname());
        }
        return courses;
    }
    
    //source:demo code
    //delete course operation
    public void delete(Course courses) {
        try {
            Course existingCourse = manager.find(Course.class, courses.getId());

            if (existingCourse != null) {
                
                manager.getTransaction().begin();
                
                manager.remove(existingCourse);
                
                manager.getTransaction().commit();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete Dialog Box");
                alert.setHeaderText("Course Deleted");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Source: Demo Code
     //source: demo code
    //read by major operation
      public List<Course> readByMajor(String major){
        Query query = manager.createNamedQuery("Course.findByMajor");
        
        query.setParameter("major", major);
        
        List<Course> courses =  query.getResultList();
        for (Course c: courses) {
            System.out.println(c.getId() + " " + c.getName() + " " + c.getMajor()+" "+c.getProname());
        }
        
        return courses;
    }
      
    //Source:Demo Code
      //read by course name operation
    public List<Course> readByCourse(String name) {
        Query query = manager.createNamedQuery("Course.findByName");

        query.setParameter("name", name);

        List<Course> courses = query.getResultList();
        for (Course course : courses) {
            System.out.println(course.getId() + " " + course.getName() + " " + course.getMajor()+" "+course.getProname());
        }

        return courses;
    }
     
    //source:demo code
    // read by course advanced operation
    public List<Course> readByCourseAdvanced(String name) {
        Query query = manager.createNamedQuery("Course.findByCourseNameAdvanced");


        query.setParameter("name", name);


        List<Course> courses = query.getResultList();
        for (Course course : courses) {
            System.out.println(course.getId() + " " + course.getName() + " " + course.getMajor()+" "+course.getProname());
        }

        return courses;
    }
//End of Course

    //Source:Demo Code
    EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Source:Demo Code
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
        
        //Source: Demo Code
        //Course Start
        CourseColum.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColum.setCellValueFactory(new PropertyValueFactory<>("id"));
        pronameColum.setCellValueFactory(new PropertyValueFactory<>("proname"));
        majorColum.setCellValueFactory(new PropertyValueFactory<>("major"));
        CourseTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //Course End
    }
    

    Scene previousScene;
    public void setPreviousScene(Scene scene) {
        Scene previousScene = scene;
        //backButton.setDisable(false);
    }
    //back to home screen
    @FXML
    void backButton1(ActionEvent event) throws IOException {
        System.out.println("clicked");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HomeScreen.fxml"));

        Parent HomeScreen = loader.load();
        Scene tableViewScene = new Scene(HomeScreen);

        HomeScreenController home = loader.getController();

        
        Scene currentScene = ((Node) event.getSource()).getScene();
        home.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }
    

}        

