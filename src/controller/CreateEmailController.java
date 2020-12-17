/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Sentemail;

/**
 * FXML Controller class
 *
 * @author a9512
 */
public class CreateEmailController implements Initializable {

    @FXML
    private TextArea labelText;
    @FXML
    private Button buttonsent;
    @FXML
    private TextField emailaddress;
    @FXML
    private TextField emailtitle;

    /**
     * Initializes the controller class.
     */
      EntityManager manager;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         manager = (EntityManager) Persistence.createEntityManagerFactory("YuanHaoHsuFXMLPU").createEntityManager();
        // TODO
    }    
   //sent an email
    @FXML
    private void sentemail(ActionEvent event) {
        String title = emailtitle.getText();
        String address = emailaddress.getText();
        String emailtext = labelText.getText();
     
        
         try {
            //Got from https://mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
          LocalDate localDate = LocalDate.now();
          String emailDate = dtf.format(localDate); 
         
            Sentemail emails = new Sentemail();
           
            emails.setEmaildate(emailDate);
            emails.setTextmessage(emailtext);
            emails.setReciever(address);
            emails.setEmailtitle(title);
            
                  Sent(emails);
                  
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Creation Dialog Box");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please Input Integer For Group ID (Group ID can Only Be less than 10 Digits)");
            alert.showAndWait();
        }

    }
    //sent email end
    
    //create email to Sentemail Database
    
     public void Sent(Sentemail emails) {
        //source:demo code     
        try {

                manager.getTransaction().begin();
            
                manager.persist(emails);

                manager.getTransaction().commit();

                System.out.println(emails.toString() + " is created");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Creation Dialog Box");
                alert.setContentText("Email Sent");
                alert.showAndWait();
            }

         catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Register Dialog Box");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Please Re-enter");
            alert.showAndWait();
            System.out.println("Invalid Input or Group ID Exsist");
            System.out.println(ex.getMessage());
        }

    }
     //sent email end
       Sentemail selectedModel;
       public void initData(Sentemail model) {
        selectedModel = model;
    }
        
    }
    

