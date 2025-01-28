import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.event.ChangeListener;

public class MainFormController {
    public TextField txtInput;
    public ListView<String> lstLanguages;
    public TextField txtOutput;
    ObservableList<String> languages = FXCollections.observableArrayList();

    public void initialize() {
        lstLanguages.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtOutput.setText(newValue);
        });
    }

    public void inputOnAction(ActionEvent actionEvent) {
        String txtLanguage = txtInput.getText();
        if(isExists(txtLanguage)==true){
            Alert alert = new Alert(Alert.AlertType.WARNING,"Already Exists");
            alert.show();
            txtInput.clear();
            return;
        }
        languages.add(txtLanguage);
        lstLanguages.setItems(languages);

        txtInput.clear();
    }
    private boolean isExists(String value){
        for(String temp : languages){
            if(temp.equals(value)){
                return true;
            }
        }
        return false;
    }

}
