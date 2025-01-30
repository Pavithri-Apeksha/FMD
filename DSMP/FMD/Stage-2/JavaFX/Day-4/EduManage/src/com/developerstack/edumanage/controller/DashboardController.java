package com.developerstack.edumanage.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashboardController {
    public Label lblDate;
    public Label lblTime;
    public AnchorPane context;
    public void initialize() {
        setDate();
    }
    public void setDate(){
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),e->{
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
                    lblTime.setText(LocalTime.now().format(dateTimeFormatter));
                }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm");
    }
    private void setUI(String location) throws IOException {
        Stage stage =(Stage)context.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location +".fxml"));
        stage.setScene(new Scene(parent));
    }

    public void openStudentFormOnAction(ActionEvent actionEvent) throws IOException {
        setUI("StudentForm");
    }

    public void openProgramFormOnAction(ActionEvent actionEvent) throws IOException {
        setUI("ProgramForm");
    }

    public void openIntakeFormOnAction(ActionEvent actionEvent) throws IOException {
        setUI("IntakeForm");
    }

    public void openTeacherFormOnAction(ActionEvent actionEvent) throws IOException {
        setUI("TeacherForm");
    }
}
