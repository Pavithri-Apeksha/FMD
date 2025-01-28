import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowAController {
    public void newWindowOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(
                FXMLLoader.load(
                        getClass().getResource("WindowB.fxml")
                )
        ));
        stage.show();
    }
}
