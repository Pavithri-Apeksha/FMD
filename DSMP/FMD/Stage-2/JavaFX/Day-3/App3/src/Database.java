import java.util.ArrayList;

public class Database {
    public static ArrayList<Customer> customerDataset = new ArrayList<>();
    static{
        customerDataset.add(new Customer("456789","Amal","Kalutara",50000));
        customerDataset.add(new Customer("123456","Nimal","Colombo",55000));
        customerDataset.add(new Customer("147258","Piyal","Gampaha",45000));
        customerDataset.add(new Customer("258369","Sunil","Matara",48000));
    }
}
