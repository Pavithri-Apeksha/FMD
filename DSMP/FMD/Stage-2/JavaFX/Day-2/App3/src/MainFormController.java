import javafx.scene.control.TextField;


public class MainFormController {

    public TextField txtInput;
    public TextField txtOutput;

    public void initialize() {
        txtInput.textProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("New Value : "+newValue);
//            System.out.println("Old value : "+oldValue);
            txtOutput.setText(newValue);
        });
    }
}
