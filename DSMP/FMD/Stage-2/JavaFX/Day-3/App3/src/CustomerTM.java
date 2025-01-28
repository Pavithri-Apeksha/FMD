import javafx.scene.control.Button;

public class CustomerTM {
    private String nic;
    private String name;
    private String address;
    private double salary;
    private Button btn;

    public String getNic() {
        return nic;
    }

    public CustomerTM(String nic, String address, String name, double salary, Button btn) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.btn = btn;
    }

    public CustomerTM() {
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
