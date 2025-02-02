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

import java.io.IOException;
import java.util.Optional;

public class LoginFormController {
    public AnchorPane loginContext;
    public TextField txtEmail;
    public TextField txtPassword;

    public void createAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUI("SignUpForm");
    }

    public void forgotPasswordOnAction(ActionEvent actionEvent) throws IOException {
        setUI("ForgotPasswordForm");

    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText().toLowerCase();
        String password = txtPassword.getText().trim();

        Optional<User> selectedUser = Database.userTable.stream().filter(e->e.getEmail().equals(email)).findFirst();
        if (selectedUser.isPresent()) {
            if(new PasswordManager().checkPassword(password,(selectedUser.get().getPassword()))) {
                setUI("Dashboard");
            }
            else{
                new Alert(Alert.AlertType.ERROR,"Invalid Password").show();
            }
        }
        else{
            new Alert(Alert.AlertType.WARNING,"User not found").show();
        }
    }
    private void setUI(String location) throws IOException {
        Stage stage =(Stage)loginContext.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location +".fxml"));
        stage.setScene(new Scene(parent));
    }
}
