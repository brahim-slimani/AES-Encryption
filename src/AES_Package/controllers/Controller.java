package AES_Package.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML private PasswordField key;
    @FXML private TextArea text;
    @FXML private TextArea result;
    @FXML private Label lb;
    public static Stage stage = new Stage();
    public static Stage view = new Stage();

    AESencryption aes = new AESencryption();

    public void connect(ActionEvent event) throws IOException {
        if(!key.getText().equals("123456")){
            lb.setText("Whoops secret code incorrect, try again !");

        }else{
            stage.close();
            Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("/AES_Package/views/viewEncryption.fxml"));
            view.setTitle("AES-Encrypt");
            view.setScene(new Scene(root));
            view.show();

        }

    }

    /**********************************crypting*****************************************/

    public void crypting(ActionEvent event){
        try {
            result.setText(aes.encrypt(text.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**********************************decrypting*****************************************/

    public void decrypting(ActionEvent event){
        try {
            result.setText(aes.decrypt(text.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /*************************************************************************************/
    public void clean(ActionEvent evant){
        text.clear();
        result.clear();
    }

    public void close(ActionEvent evant){
        view.close();
    }

    public void exit(ActionEvent event){
        System.exit(0);
    }

}



