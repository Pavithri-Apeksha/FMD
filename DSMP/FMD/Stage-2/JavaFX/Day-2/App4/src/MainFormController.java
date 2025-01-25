import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class MainFormController {
    public ComboBox<String> cmbLanguages;
    public TextField txtSelectedLanguage;
    public ComboBox<String> cmbCity;
    public TextField txtSelectedCity;
    ArrayList<String> myArrayCity = new ArrayList<>(
            Arrays.asList("Kalutara","Colombo","Galle","Kandy","Gampaha","Matara")
    );
    ArrayList<String> myArrayList = new ArrayList<>(
            Arrays.asList("Java","PHP","C#","Kotlin")
    );

    public void initialize(){
        cmbLanguages.getItems().addAll(myArrayList);
//        ObservableList<String> obList = FXCollections.observableArrayList(myArrayList);
//        cmbLanguages.setItems(obList);
//        for(String temp : myArrayList){
//            cmbLanguages.getItems().add(temp);
//        }
        cmbLanguages.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtSelectedLanguage.setText(newValue);
        });
        cmbCity.getItems().addAll(myArrayCity);
        cmbCity.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtSelectedCity.setText(newValue);
        });
    }
}
