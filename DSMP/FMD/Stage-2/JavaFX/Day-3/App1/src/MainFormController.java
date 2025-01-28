import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class MainFormController {

    public CheckBox cbxJava;
    public CheckBox cbxKotlin;
    public CheckBox cbxRuby;
    public TextField txtData;

    public void printDataOnAction(ActionEvent actionEvent) {
        ArrayList<String> languages = new ArrayList<>();
        if (cbxJava.isSelected()) {
            languages.add("Java");
        }
        if (cbxKotlin.isSelected()) {
            languages.add("Kotlin");
        }
        if (cbxRuby.isSelected()) {
            languages.add("Ruby");
        }
        System.out.println(languages);
    }

    public void typeOnAction(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)){
            System.out.println(txtData.getText());
        }
    }
}
