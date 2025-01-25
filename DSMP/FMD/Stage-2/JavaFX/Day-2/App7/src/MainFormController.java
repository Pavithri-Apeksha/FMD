import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class MainFormController {
    public RadioButton tBtnMale;
    public ToggleGroup gender;
    public RadioButton rBtnFemale;

    public void printDataOnAction(ActionEvent actionEvent) {
        System.out.println(rBtnFemale.isSelected()?"Female":"Male");
//        if(rBtnFemale.isSelected()){
//            System.out.println("Female");
//        }
//        else{
//            System.out.println("Male");
//        }
    }
}
