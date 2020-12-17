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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Sentemail;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class SentMailController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button buttonDeleteEmail;
    @FXML
    private Button searchEmailButton;
    @FXML
    private Button buttonAdvanceSearch;
    @FXML
    private Button buttonShowDetail;
    @FXML
    private TableView<Sentemail> emailTable;
    @FXML
    private TableColumn<Sentemail, Integer> canvasaccountid;
    @FXML
    private TableColumn<Sentemail, String> emailsender;
    @FXML
    private TableColumn<Sentemail, String> emailtitle;
    @FXML
    private TableColumn<Sentemail, String> emailtext;
    @FXML
    private TableColumn<Sentemail, String> emaildate;
    @FXML
    private TextField textboxSender;
    @FXML
    private Button backButton;
    @FXML
    private Button viewSent;

    /**
     * Initializes the controller class.
     */
    EntityManager manager;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();

        canvasaccountid.setCellValueFactory(new PropertyValueFactory<>("emailid"));
        emailsender.setCellValueFactory(new PropertyValueFactory<>("reciever"));
        emailtitle.setCellValueFactory(new PropertyValueFactory<>("emailtitle"));
        emailtext.setCellValueFactory(new PropertyValueFactory<>("textmessage"));
        emaildate.setCellValueFactory(new PropertyValueFactory<>("emaildate"));
        // TODO
    }
//delete email

    @FXML
    private void deleteEmail(ActionEvent event) {
        Sentemail selectedMail = emailTable.getSelectionModel().getSelectedItem();

        initData(selectedMail);
    }
    //delete end   
    Sentemail selectedModel;
// get selected model's id

    public void initData(Sentemail model) {
        selectedModel = model;
        int id = model.getEmailid();
        Sentemail s = readById(id);
        delete(s);

    }
    //code end

    // read email id
    //from class code
    public Sentemail readById(int id) {
        Query query = manager.createNamedQuery("Sentemail.findByEmailid");

        query.setParameter("emailid", id);

        Sentemail s = (Sentemail) query.getSingleResult();
        if (s != null) {
            System.out.println(s.getEmaildate() + " " + s.getEmailtitle() + " " + s.getReciever() + " " + s.getTextmessage());
        }

        return s;
    }

    // Delete operation from class code
    public void delete(Sentemail email) {
        try {
            Sentemail existingEmail = manager.find(Sentemail.class, email.getEmailid());

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
//search by email address

    @FXML
    private void searchByEmailAction(ActionEvent event) {
        //Source: Demo Code     
        String emailsender = textboxSender.getText();
        System.out.println(emailsender);

        List<Sentemail> email = readByEmailAddress(emailsender);
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
//search end

    //from class code
    public List<Sentemail> readByEmailAddress(String emailsender) {
        Query query = manager.createNamedQuery("Sentemail.findByReciever");

        query.setParameter("reciever", emailsender);

        List<Sentemail> emails = query.getResultList();
        for (Sentemail e : emails) {
            System.out.println(e.getEmaildate() + " " + e.getEmailtitle() + " " + e.getReciever() + " " + e.getTextmessage());
        }

        return emails;
    }
// search advanced

    @FXML
    private void searchByEmailAdvancedAction(ActionEvent event) {
        //source: demo code
        System.out.println("clicked");

        String email = textboxSender.getText();

        List<Sentemail> emails = readByEmailAddressAdvanced(email);

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
// search advanced operation
    //source:demo code

    public List<Sentemail> readByEmailAddressAdvanced(String email) {
        Query query = manager.createNamedQuery("Sentemail.findByRecieverAdvanced");

        query.setParameter("reciever", email);

        List<Sentemail> emails = query.getResultList();

        for (Sentemail e : emails) {
            System.out.println(e.getEmaildate() + " " + e.getEmailtitle() + " " + e.getReciever() + " " + e.getTextmessage());
        }

        return emails;
    }
    // Search Email Advance Method End

    // show email details, it will transit to sent email detail scene
    @FXML
    private void actionShowDetails(ActionEvent event) throws IOException {
        //Source: Demo Code  
        Sentemail selectedMail = emailTable.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SentMailboxDetail.fxml"));

        Parent SentMailboxDetail = loader.load();

        Scene tableViewScene = new Scene(SentMailboxDetail);

        SentMailboxDetailModelController detailedControlled = loader.getController();

        detailedControlled.initData(selectedMail);

        Stage stage = new Stage();
        stage.setScene(tableViewScene);
        stage.show();
    }

    // back to mailbox
    @FXML
    private void backButton1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MailboxMenuView.fxml"));

        Parent MailboxMenuLoader = loader.load();
        Scene tableViewScene = new Scene(MailboxMenuLoader);

        MailboxMenuController mailbox = loader.getController();

        Scene currentScene = ((Node) event.getSource()).getScene();
        mailbox.setPreviousScene(currentScene);

        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(tableViewScene);
        stage.show();
    }
// view all sent emails

    @FXML
    private void viewSentEmail(ActionEvent event) {
        Query query = manager.createNamedQuery("Sentemail.findAll");
        List<Sentemail> emails = query.getResultList();

        for (Sentemail s : emails) {
            System.out.println(s.getEmailid() + " " + s.getReciever() + " " + s.getTextmessage() + " " + s.getEmailtitle() + " " + s.getEmaildate());
        }
        setTableData(emails);

    }

    private ObservableList<Sentemail> sentemailData;
//set up table

    public void setTableData(List<Sentemail> sentemailList) {

        sentemailData = FXCollections.observableArrayList();

        sentemailList.forEach(c -> {
            sentemailData.add(c);
        });

        emailTable.setItems(sentemailData);
        emailTable.refresh();
    }

    Scene previousScene;

    public void setPreviousScene(Scene scene) {
        Scene previousScene = scene;
        //backButton.setDisable(false);
    }

}
