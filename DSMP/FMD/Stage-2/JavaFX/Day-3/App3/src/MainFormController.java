import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class MainFormController {
    public TableColumn<CustomerTM,String> colNIC;
    public TableView<CustomerTM> tblCustomer;
    public TableColumn<CustomerTM,String> colName;
    public TableColumn<CustomerTM,String> colAddress;
    public TableColumn<CustomerTM,Double> colSalary;
    public TableColumn<CustomerTM, Button> colDelete;

    public void initialize() {
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadData();

    }

    private void loadData() {
        ObservableList<CustomerTM> observableList = FXCollections.observableArrayList();

        for (Customer c : Database.customerDataset) {
            Button btn = new Button("Delete");
            CustomerTM customerTM = new CustomerTM(
                    c.getNic(), c.getName(), c.getAddress(), c.getSalary(), btn
            );

            btn.setOnAction((e) -> {
                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure?", ButtonType.NO, ButtonType.YES);
                Optional<ButtonType> buttonType = confirmation.showAndWait();
                if (buttonType.get() == ButtonType.YES) {
                    Database.customerDataset.remove(c);
                    observableList.remove(customerTM);
                }
            });
            observableList.add(customerTM);
        }
        tblCustomer.setItems(observableList);
    }

}
