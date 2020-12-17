/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import model.Mailbox;

/**
 *
 * @author cge19
 */
public class MailboxMenuController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Button buttonCreateEmail;

    @FXML
    private Button buttonDeleteEmail;

    @FXML
    private Button buttonReadByEmailAddress;

    @FXML
    private TextField textboxSender;

    @FXML
    private TableView<Mailbox> emailTable;

    @FXML
    private TableColumn<Mailbox, Integer> canvasaccountid;

    @FXML
    private TableColumn<Mailbox, String> emailsender;

    @FXML
    private TableColumn<Mailbox, String> emailtitle;

    @FXML
    private TableColumn<Mailbox, String> emaildate;
    @FXML
    private TableColumn<Mailbox, String> emailtext;

    @FXML
    private Button backButton;

    private ObservableList<Mailbox> emailData;

    @FXML
    private Button buttonReplyEmails;
    @FXML
    private Button searchEmailButton;
    @FXML
    private Button buttonAdvanceSearch;
    @FXML
    private Button buttonShowDetail;
    @FXML
    private Button viewSent;

//Setting table data
    public void setTableData(List<Mailbox> emails) {
        emailData = FXCollections.observableArrayList();
        System.out.println("Hello");
        emails.forEach(s -> {
            emailData.add(s);
        });
        emailTable.setItems(emailData);
        emailTable.refresh();
        System.out.println("Hello2");
    }
    //code end

// Search Email
    @FXML
    void searchByEmailAction(ActionEvent event) {
        System.out.println("Clicked");
        //Source: Demo Code     
        String emailsender = textboxSender.getText();
        System.out.println(emailsender);

        List<Mailbox> email = readByEmailAddress(emailsender);
        if (email == null || email.isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Email Found");
            alert.showAndWait();
        } else {
            setTableData(email);
        }

    }
// Search Email End

// Search Email Advance
    @FXML
    void searchByEmailAdvancedAction(ActionEvent event) {
        //source: demo code
        System.out.println("clicked");

        String email = textboxSender.getText();

        List<Mailbox> emails = readByEmailAddressAdvanced(email);

        if (emails == null || emails.isEmpty()) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Search Dialog Box");
            alert.setHeaderText("Search Results");
            alert.setContentText("No Email Found");
            alert.showAndWait();
        } else {

            setTableData(emails);
        }
// Seach Email Advance end
    }

    // Search Email Advance Method
    //source:demo code
    public List<Mailbox> readByEmailAddressAdvanced(String email) {
        Query query = manager.createNamedQuery("Mailbox.findBySenderAdvanced");

        query.setParameter("emailsender", email);

        List<Mailbox> emails = query.getResultList();

        for (Mailbox e : emails) {
            System.out.println(e.getCanvasaccountid() + " " + e.getEmailsender() + " " + e.getEmailtitle() + " " + e.getEmailtext() + " " + e.getEmaildate());
        }

        return emails;
    }

    // Search Email Advance Method End
    //Show email's detail
    @FXML
    void actionShowDetails(ActionEvent event) throws IOException {
        System.out.println("clicked");

        //Source: Demo Code  
        Mailbox selectedMail = emailTable.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MailboxDetailModelView.fxml"));

        Parent MailboxDetailModelView = loader.load();

        Scene tableViewScene = new Scene(MailboxDetailModelView);

        MailboxDetailModelController detailedControlled = loader.getController();

        detailedControlled.initData(selectedMail);

        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();
    }
    //Code End

//create an email, it will pop up a sent email window
    @FXML
    void createEmail(ActionEvent event) throws IOException {
        //Source: Demo Code  

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/createEmail.fxml"));

        Parent createEmail = loader.load();

        Scene tableViewScene = new Scene(createEmail);

        CreateEmailController detailedControlled = loader.getController();

        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();

    }
    //create email end

// delete email
    @FXML
    void deleteEmail(ActionEvent event) {
        Mailbox selectedMail = emailTable.getSelectionModel().getSelectedItem();

        initData(selectedMail);

    }
    // delete end
    Mailbox selectedModel;
// get selected model's id

    public void initData(Mailbox model) {
        selectedModel = model;
        int id = model.getCanvasaccountid();
        Mailbox e = readById(id);
        delete(e);

    }
    //code end

    // Database manager Got from class code
    EntityManager manager;

    @Override //Got from class code
    public void initialize(URL url, ResourceBundle rb) {
        //database reference: "IntroJavaFXPU"
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();

        // CODE FROM SAMPLE
        canvasaccountid.setCellValueFactory(new PropertyValueFactory<>("Canvasaccountid"));
        emailsender.setCellValueFactory(new PropertyValueFactory<>("Emailsender"));
        emailtitle.setCellValueFactory(new PropertyValueFactory<>("Emailtitle"));
        emailtext.setCellValueFactory(new PropertyValueFactory<>("Emailtext"));
        emaildate.setCellValueFactory(new PropertyValueFactory<>("Emaildate"));

        //eanble row selection
        emailTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    /*
    Implementing CRUD operations Got from class code
     */
    //from class code
    public Mailbox readById(int id) {
        Query query = manager.createNamedQuery("Mailbox.findByCanvasaccountid");

        query.setParameter("canvasaccountid", id);

        Mailbox e = (Mailbox) query.getSingleResult();
        if (e != null) {
            System.out.println(e.getCanvasaccountid() + " " + e.getEmailsender() + " " + e.getEmailtitle());
        }

        return e;
    }

    //from class code
    public List<Mailbox> readByEmailAddress(String emailsender) {
        Query query = manager.createNamedQuery("Mailbox.findByName");

        query.setParameter("emailsender", emailsender);

        List<Mailbox> emails = query.getResultList();
        for (Mailbox e : emails) {
            System.out.println(e.getCanvasaccountid() + " " + e.getEmailsender() + " " + e.getEmailtitle() + " " + e.getEmailtext() + " " + e.getEmaildate());
        }

        return emails;
    }

    // Delete operation from class code
    public void delete(Mailbox email) {
        try {
            Mailbox existingEmail = manager.find(Mailbox.class, email.getCanvasaccountid());

            if (existingEmail != null) {

                manager.getTransaction().begin();

                manager.remove(existingEmail);

                manager.getTransaction().commit();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete Dialog Box");
                alert.setHeaderText("Email Deleted");
                alert.showAndWait();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Dialog Box");
            alert.setHeaderText("Email Already Deleted");
            alert.showAndWait();

        }
    }

    Scene previousScene;

    public void setPreviousScene(Scene scene) {
        Scene previousScene = scene;
        //backButton.setDisable(false);
    }
// get back to home page

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

//read all emails
    @FXML
    private void readAllEmails(ActionEvent event) {
        Query query = manager.createNamedQuery("Mailbox.findAll");
        List<Mailbox> courses = query.getResultList();

        for (Mailbox e : courses) {
            System.out.println(e.getCanvasaccountid() + " " + e.getEmailsender() + " " + e.getEmailtitle() + " " + e.getEmailtext() + " " + e.getEmaildate());
        }
        setTableData(courses);
    }
    //code end
// view sented email, it will load email sent scene

    @FXML
    private void viewSentEmail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SentMailbox.fxml"));

        Parent SentMailLoader = loader.load();
        Scene tableViewScene = new Scene(SentMailLoader);

        SentMailController sentmail = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        sentmail.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();

    } // code end
} // end of mailboxMenu
