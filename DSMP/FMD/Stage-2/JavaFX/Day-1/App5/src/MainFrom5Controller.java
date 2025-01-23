import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class MainFrom5Controller {
    public TextField txtUserName;
    public TextField txtMyName;

    public void printMyName(ActionEvent actionEvent) {
        String UserName = txtUserName.getText();
        txtMyName.setText(UserName);

    }
}
