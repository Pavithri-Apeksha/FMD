import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MainFormController {
    public TextField txtKeyPressed;
    public TextField txtKeyPressedAnswer;
    public TextField txtKeyReleased;
    public TextField txtKeyReleasedAnswer1;

    public void onKeyPressedActionEvent(KeyEvent keyEvent) {
        String text = txtKeyPressed.getText();
        txtKeyPressedAnswer.setText(text);
    }

    public void onKeyReleasedActionEvent(KeyEvent keyEvent) {
        String text = txtKeyReleased.getText();
        txtKeyReleasedAnswer1.setText(text);
    }
}
