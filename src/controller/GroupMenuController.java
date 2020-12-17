/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Groups;
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
public class GroupMenuController implements Initializable {

    private Label label;
    @FXML
    private Button createbutton;
    @FXML
    private Button readbutton;
    @FXML
    private Button updatebutton;
    @FXML
    private Button searchbygroupname;
    @FXML
    private Button readbycourse;
    @FXML
    private Button searchButton;
    @FXML
    private TableView<Groups> CourseTable;
    @FXML
    private TableColumn<Groups, Integer> idColum;
    @FXML
    private TableColumn<Groups, String> groupnameColum;
    @FXML
    private TableColumn<Groups, String> courseColum;
    @FXML
    private TableColumn<Groups, String> memberColum1;
    @FXML
    private TableColumn<Groups, String> memberColum2;
    @FXML
    private TableColumn<Groups, String> memberColum3;
    @FXML
    private TableColumn<Groups, String> memberColum4;
    @FXML
    private TableColumn<Groups, String> memberColum5;
    @FXML
    private TableColumn<Groups, String> memberColum6;
    @FXML
    private TableColumn<Groups, String> memberColum7;
    @FXML
    private TableColumn<Groups, String> memberColum8;
    @FXML
    private TableColumn<Groups, String> memberColum9;
    @FXML
    private TableColumn<Groups, String> memberColum10;
    @FXML
    private TextField searchBar;
    @FXML
    private TextField searchBar1;
    @FXML
    private TextField searchBar2;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    EntityManager manager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
        // TODO
        //Source: Demo Code    
        idColum.setCellValueFactory(new PropertyValueFactory<>("groupid"));
        groupnameColum.setCellValueFactory(new PropertyValueFactory<>("groupname"));
        courseColum.setCellValueFactory(new PropertyValueFactory<>("courseattribute"));
        memberColum1.setCellValueFactory(new PropertyValueFactory<>("member1"));
        memberColum2.setCellValueFactory(new PropertyValueFactory<>("member2"));
        memberColum3.setCellValueFactory(new PropertyValueFactory<>("member3"));
        memberColum4.setCellValueFactory(new PropertyValueFactory<>("member4"));
        memberColum5.setCellValueFactory(new PropertyValueFactory<>("member5"));
        memberColum6.setCellValueFactory(new PropertyValueFactory<>("member6"));
        memberColum7.setCellValueFactory(new PropertyValueFactory<>("member7"));
        memberColum8.setCellValueFactory(new PropertyValueFactory<>("member8"));
        memberColum9.setCellValueFactory(new PropertyValueFactory<>("member9"));
        memberColum10.setCellValueFactory(new PropertyValueFactory<>("member10"));
    }
    // create group

    @FXML
    private void createGroup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/createGroup.fxml"));

        Parent createGroupLoader = loader.load();
        Scene tableViewScene = new Scene(createGroupLoader);

        CreateGroupController createGroup = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        createGroup.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();

    }

    //create group end
    //read all groups
    @FXML
    private void readAll(ActionEvent event) {
        //source:demo code
        Query query = manager.createNamedQuery("Groups.findAll");
        List<Groups> data = query.getResultList();

        for (Groups g : data) {
            System.out.println(g.getGroupid() + " " + g.getGroupname() + " " + g.getCourseattribute() + " " + g.getMember1() + " " + g.getMember2() + " " + g.getMember3()
                    + " " + g.getMember4() + " " + g.getMember5() + " " + g.getMember6() + " " + g.getMember7() + " " + g.getMember8() + " " + g.getMember9() + " " + g.getMember10());
        }
        setTableData(data);
    }
    //read end

    //Source: Demo Code
    private ObservableList<Groups> groupsData;

    public void setTableData(List<Groups> groups) {

        groupsData = FXCollections.observableArrayList();

        groups.forEach(s -> {
            groupsData.add(s);
        });
        CourseTable.setItems(groupsData);
        CourseTable.refresh();
    }
// update group, transit to upadate scene

    @FXML
    private void updateGroup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/updateGroup.fxml"));

        Parent updateGroupLoader = loader.load();
        Scene tableViewScene = new Scene(updateGroupLoader);

        UpdateGroupController studentUpdate = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        studentUpdate.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();

    }
// update end

// read by group name
    @FXML
    private void readByGroupName(ActionEvent event) {
        //source:Demo code
        System.out.println("clicked");

        String groupName = searchBar1.getText();

        List<Groups> groups = readByGroupName(groupName);

        if (groups == null || groups.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Group Found");
            alert.showAndWait();
        } else {

            setTableData(groups);
        }
    }
    // read end
    // read by group name operation

    public List<Groups> readByGroupName(String groupname) {
        Query query = manager.createNamedQuery("Groups.findByGroupname");

        query.setParameter("groupname", groupname);

        List<Groups> groups = query.getResultList();
        for (Groups g : groups) {
            System.out.println(g.getGroupid() + " " + g.getGroupname() + " " + g.getCourseattribute() + " " + g.getMember1() + " " + g.getMember2() + " " + g.getMember3()
                    + " " + g.getMember4() + " " + g.getMember5() + " " + g.getMember6() + " " + g.getMember7() + " " + g.getMember8() + " " + g.getMember9() + " " + g.getMember10());
        }

        return groups;
    }
// read by course

    @FXML
    private void readByCourse(ActionEvent event) {
        //source:Demo code
        System.out.println("clicked");

        String course = searchBar2.getText();

        List<Groups> groups = readByCourse(course);

        if (groups == null || groups.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Group Found");
            alert.showAndWait();
        } else {

            setTableData(groups);
        }
    }

    // read by course operation
    public List<Groups> readByCourse(String courseattribute) {
        Query query = manager.createNamedQuery("Groups.findByCourseattribute");

        query.setParameter("courseattribute", courseattribute);

        List<Groups> groups = query.getResultList();
        for (Groups g : groups) {
            System.out.println(g.getGroupid() + " " + g.getGroupname() + " " + g.getCourseattribute() + " " + g.getMember1() + " " + g.getMember2() + " " + g.getMember3()
                    + " " + g.getMember4() + " " + g.getMember5() + " " + g.getMember6() + " " + g.getMember7() + " " + g.getMember8() + " " + g.getMember9() + " " + g.getMember10());
        }

        return groups;
    }
// search by group id

    @FXML
    private void searchButton1(ActionEvent event) {
        //source:Demo code
        System.out.println("clicked");

        String Groupid = searchBar.getText();
        int groupidtoint = Integer.parseInt(Groupid);
        int integerid = groupidtoint;

        List<Groups> groups = readByGroupid(integerid);

        if (groups == null || groups.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Group Found");
            alert.showAndWait();
        } else {

            setTableData(groups);
        }

    }

    // search by group id operation   
    //source:demo code
    public List<Groups> readByGroupid(Integer id) {
        Query query = manager.createNamedQuery("Groups.findByGroupid");

        query.setParameter("groupid", id);

        List<Groups> groups = query.getResultList();
        for (Groups g : groups) {
            System.out.println(g.getGroupid() + " " + g.getGroupname() + " " + g.getCourseattribute() + " " + g.getMember1() + " " + g.getMember2() + " " + g.getMember3()
                    + " " + g.getMember4() + " " + g.getMember5() + " " + g.getMember6() + " " + g.getMember7() + " " + g.getMember8() + " " + g.getMember9() + " " + g.getMember10());
        }

        return groups;
    }

    Scene previousScene;

    public void setPreviousScene(Scene scene) {
        previousScene = scene;
    }

    @FXML
    private Button backButton;

    // back to home screen
    @FXML
    void backButton1(ActionEvent event) throws IOException {
        System.out.print("hi");
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
