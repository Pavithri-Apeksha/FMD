import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardController {
    public AnchorPane context;
    public void initialize() throws IOException {
        setUI("WindowAForm");
    }
    public void openWindowAOnAction(ActionEvent actionEvent) throws IOException {
        setUI("WindowAForm");
    }

    public void openWindowBOnAction(ActionEvent actionEvent) throws IOException {
        setUI("WindowBForm");
    }
    private void setUI(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(
                FXMLLoader.load(getClass().getResource(location+".fxml"))
        );
    }
}
