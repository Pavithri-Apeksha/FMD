package com.developerstack.edumanage.controller;

import com.developerstack.edumanage.db.Database;
import com.developerstack.edumanage.model.Student;
import com.developerstack.edumanage.view.tm.StudentTm;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;


public class StudentFormController {
    public TextField txtId;
    public TextField txtName;
    public DatePicker txtDOB;
    public TextField txtAddress;
    public AnchorPane context;
    public TableView<StudentTm> tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colDOB;
    public TableColumn colAddress;
    public TableColumn colOption;
    public Button btnSave;
    public TextField txtSearch;

    String searchText = "";

    public void initialize() {
        setID();
        setTableData(searchText);
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        tblStudent.getSelectionModel()
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

    private void setData(StudentTm tm) {
        txtId.setText(tm.getId());
        txtName.setText(tm.getFullName());
        txtDOB.setValue(LocalDate.parse(tm.getDob(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        txtAddress.setText(tm.getAddress());
        btnSave.setText("Update Student");
    }

    private void setTableData(String searchText) {
        ObservableList<StudentTm> observableList = FXCollections.observableArrayList();
        for (Student st :Database.studentTable){
            if(st.getFullName().contains(searchText)){
                Button btn = new Button("Delete");
                observableList.add(new StudentTm(
                        st.getId(),
                        st.getFullName(),
                        st.getDateOfBirth().toString(),
                        st.getAddress(),
                        btn
                ));
                btn.setOnAction(e->{
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are You Sure?",
                            ButtonType.YES,ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if(buttonType.get().equals(ButtonType.YES)){
                        Database.studentTable.remove(st);
                        new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
                        setTableData(searchText);
                        setID();
                    }
                });
            }

        }
        tblStudent.setItems(observableList);
    }

    private void setID() {
        if(!Database.studentTable.isEmpty()){
            Student lastStudent = Database.studentTable.get(
                    Database.studentTable.size() - 1
            );
            String lastId = lastStudent.getId();
            String[] splitData = lastId.split("-");
            int lastIdIntegerNumber = Integer.parseInt(splitData[1]);
            lastIdIntegerNumber++;
            String generateId = "S-" + lastIdIntegerNumber;
            txtId.setText(generateId);

        }
        else{
            txtId.setText("S-1");
        }
    }

    public void saveStudentOnAction(ActionEvent actionEvent) {
        if (btnSave.getText().equalsIgnoreCase("Save Student")) {
            LocalDate localDate = txtDOB.getValue();
            Date date = java.sql.Date.valueOf(localDate);
            Student student = new Student(
                    txtId.getText(),
                    txtName.getText(),
                    date,
                    txtAddress.getText()
            );
            Database.studentTable.add(student);
            setID();
            clearData();
            setTableData(searchText);
            new Alert(Alert.AlertType.CONFIRMATION, "Student Added Successfully").show();
        }
        else {
            for(Student st : Database.studentTable){
                if(st.getId().equals(txtId.getText())){
                    st.setFullName(txtName.getText());
                    st.setDateOfBirth(java.sql.Date.valueOf(txtDOB.getValue()));
                    st.setAddress(txtAddress.getText());
                    setTableData(searchText);
                    clearData();
                    setID();
                    new Alert(Alert.AlertType.CONFIRMATION, "Student Updated Successfully").show();
                    btnSave.setText("Save Student");
                    return;
                }
            }
            new Alert(Alert.AlertType.WARNING, "Not found").show();
        }
    }

    private void clearData() {
        txtName.clear();
        txtAddress.clear();
        txtDOB.setValue(null);
    }

    public void newStudentOnAction(ActionEvent actionEvent) {
        clearData();
        setID();
        btnSave.setText("Save Student");
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUI("Dashboard");
    }
    private void setUI(String location) throws IOException {
        Stage stage =(Stage)context.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/"+location +".fxml"));
        stage.setScene(new Scene(parent));
    }
}
