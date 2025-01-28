package com.developerstack.edumanage.controller;

import com.developerstack.edumanage.db.Database;
import com.developerstack.edumanage.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class SignUpFormController {
    public AnchorPane signUpContext;
    public TextField txtEmail;
    public TextField txtPassword;
    public TextField txtFirstName;
    public TextField txtLastName;

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
        String email = txtEmail.getText().toLowerCase();
        String password = txtPassword.getText().trim();
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        Database.userTable.add(
                new User(email, password, firstName, lastName)
        );
        new Alert(Alert.AlertType.CONFIRMATION, "Sign Up Successful").show();
        setUI("LoginForm");
    }

    public void alreadyAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm");
    }
    public void setUI(String location) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"));
        Stage stage = (Stage)signUpContext.getScene().getWindow();
        stage.setScene(new Scene(parent));

    }
}
