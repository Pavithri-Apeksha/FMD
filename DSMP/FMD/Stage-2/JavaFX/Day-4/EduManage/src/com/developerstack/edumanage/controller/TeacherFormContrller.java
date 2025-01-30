package com.developerstack.edumanage.controller;

import com.developerstack.edumanage.db.Database;
import com.developerstack.edumanage.model.Teacher;
import com.developerstack.edumanage.view.tm.TeacherTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class TeacherFormContrller {
    public TextField txtCode;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSearch;
    public Button btnSave;
    public TableView<TeacherTm> tblTeacher;
    public TextField txtContactNo;
    public AnchorPane context;
    public TableColumn colCode;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colOption;

    String searchText = "";

    public void initialize() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        setCode();
        setTableData(searchText);
        tblTeacher.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if(null != newValue) {
                        setData(newValue);
                    }

                });
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText = newValue;
            setTableData(searchText);
        });
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUI("Dashboard");
    }

    public void newTeacherOnAction(ActionEvent actionEvent) {
        clearData();
        setCode();
        btnSave.setText("Save Teacher");
    }

    private void setUI(String location) throws IOException {
        Stage stage =(Stage)context.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location +".fxml"));
        stage.setScene(new Scene(parent));
    }
    private void setCode() {
        if(!Database.teacherTable.isEmpty()){
            Teacher lastTeacher = Database.teacherTable.get(
                    Database.teacherTable.size() - 1
            );
            String lastCode = lastTeacher.getCode();
            String[] splitData = lastCode.split("-");
            int lastCodeIntegerNumber = Integer.parseInt(splitData[1]);
            lastCodeIntegerNumber++;
            String generateCode = "T-" + lastCodeIntegerNumber;
            txtCode.setText(generateCode);

        }
        else{
            txtCode.setText("T-1");
        }
    }
    private void setTableData(String searchText) {
        ObservableList<TeacherTm> observableList = FXCollections.observableArrayList();
        for (Teacher tc :Database.teacherTable){
            if(tc.getName().contains(searchText)){
                Button btn = new Button("Delete");
                observableList.add(new TeacherTm(
                        tc.getCode(),
                        tc.getName(),
                        tc.getAddress(),
                        tc.getContactNo(),
                        btn
                ));
                btn.setOnAction(e->{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure?",
                            ButtonType.YES,ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if(buttonType.get().equals(ButtonType.YES)){
                        Database.teacherTable.remove(tc);
                        new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
                        setTableData(searchText);
                        setCode();
                    }
                });
            }

        }
        tblTeacher.setItems(observableList);
    }
    private void setData(TeacherTm tm) {
        txtCode.setText(tm.getCode());
        txtName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtContactNo.setText(tm.getContactNo());
        btnSave.setText("Update Teacher");
    }
    public void clearData(){
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
    }

    public void saveTeacherOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equalsIgnoreCase("Save Teacher")) {
            Teacher teacher = new Teacher(
                    txtCode.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    txtContactNo.getText()
            );
            Database.teacherTable.add(teacher);
            setCode();
            clearData();
            setTableData(searchText);
            new Alert(Alert.AlertType.CONFIRMATION, "Teacher Added Successfully").show();
        }
        else {
            for(Teacher tc : Database.teacherTable){
                if(tc.getCode().equals(txtCode.getText())){
                    tc.setName(txtName.getText());
                    tc.setAddress(txtAddress.getText());
                    tc.setContactNo(txtContactNo.getText());
                    setTableData(searchText);
                    clearData();
                    setCode();
                    new Alert(Alert.AlertType.CONFIRMATION, "Teacher Updated Successfully").show();
                    btnSave.setText("Save Teacher");
                    return;
                }
            }
            new Alert(Alert.AlertType.WARNING, "Not found").show();
        }
    }
}
