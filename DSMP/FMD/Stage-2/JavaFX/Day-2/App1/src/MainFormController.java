import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class MainFormController {
    public TextField txtMyName;
    public TextField txtEmail;

    public void btnPrintOnAction(ActionEvent actionEvent) {
        String myName = txtMyName.getText();
        System.out.println(myName);
    }

    public void txtPrintEmailOnAction(ActionEvent actionEvent) {
        System.out.println(txtEmail.getText());
    }
}
