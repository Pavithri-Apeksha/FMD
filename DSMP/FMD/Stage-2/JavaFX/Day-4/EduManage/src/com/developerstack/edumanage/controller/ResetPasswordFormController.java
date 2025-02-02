package com.developerstack.edumanage.controller;

import com.developerstack.edumanage.db.Database;
import com.developerstack.edumanage.model.User;
import com.developerstack.edumanage.util.security.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Optional;

public class ResetPasswordFormController {
    public AnchorPane context;
    public TextField txtNewPassword;

    String selectedEmail = "";
    public void setUserData(String email) {
        selectedEmail = email;
        System.out.println(selectedEmail);
    }


    public void resetPasswordOnAction(ActionEvent actionEvent) throws IOException {
        Optional<User> selectedUser = Database.userTable.stream().filter(e -> e.getEmail().equals(selectedEmail)).findFirst();
        if (selectedUser.isPresent()) {
            selectedUser.get().setPassword(new PasswordManager().encrypt(txtNewPassword.getText()));
            setUI("LoginForm");
        }
        else{
            new Alert(Alert.AlertType.ERROR,"Not Found").show();
        }
    }
    private void setUI(String location) throws IOException {
        Stage stage =(Stage)context.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location +".fxml"));
        stage.setScene(new Scene(parent));
    }
}
