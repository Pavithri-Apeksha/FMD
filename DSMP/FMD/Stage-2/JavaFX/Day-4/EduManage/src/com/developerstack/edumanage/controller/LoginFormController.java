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

public class LoginFormController {
    public AnchorPane loginContext;
    public TextField txtEmail;
    public TextField txtPassword;

    public void createAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUI("SignUpForm");
    }

    public void forgotPasswordOnAction(ActionEvent actionEvent) {

    }

    public void loginOnAction(ActionEvent actionEvent) {
        String email = txtEmail.getText().toLowerCase();
        String password = txtPassword.getText().trim();
        for (User user: Database.userTable){
            if (user.getEmail().equals(email)){
                if(user.getPassword().equals(password)){
                    System.out.println(user.toString());
                }
                else{
                    new Alert(Alert.AlertType.ERROR,"Wrong Password").show();
                }
                return;
            }
        }
        new Alert(Alert.AlertType.WARNING,String.format("User not fount (%s)",email)).show();
    }
    private void setUI(String location) throws IOException {
        Stage stage =(Stage)loginContext.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location +".fxml"));
        stage.setScene(new Scene(parent));
    }
}
