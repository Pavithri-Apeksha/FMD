import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowAFormController {
    public AnchorPane contextA;

    public void nextOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent =  FXMLLoader.load(getClass().getResource("WindowBForm.fxml"));
        Stage stage = (Stage)contextA.getScene().getWindow();
        stage.setScene(new Scene(parent));
    }
}
