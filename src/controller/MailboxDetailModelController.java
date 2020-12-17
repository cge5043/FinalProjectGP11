
package controller;



import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import model.Mailbox;

/**
 *
 * @author cge19
 * I referenced sample code that was provided
 */
public class MailboxDetailModelController {
    

    @FXML 
    private Label labelTitle; // Value injected by FXMLLoader

    @FXML 
    private TextArea labelText; // Value injected by FXMLLoader

    @FXML 
    private ImageView image; // Value injected by FXMLLoader

    

    Mailbox selectedModel;

   // set email text and sender
    public void initData(Mailbox model) {
        selectedModel = model;
        labelText.setText(model.getEmailtext());
        labelTitle.setText(model.getEmailsender());
    }
   //code end 

    void initialize() {
        assert labelText != null : "fx:id=\"labelText\" was not injected: check your FXML file 'DetailModelView.fxml'.";
        assert labelTitle != null : "fx:id=\"labelTitle\" was not injected: check your FXML file 'DetailModelView.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'DetailModelView.fxml'.";

    }
}
