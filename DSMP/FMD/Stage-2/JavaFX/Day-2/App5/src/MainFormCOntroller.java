import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class MainFormCOntroller {
    public PieChart chart;
    public void initialize(){
        ObservableList<PieChart.Data> myData = FXCollections.observableArrayList();
        myData.addAll(new PieChart.Data("Java", 250),
                new PieChart.Data("PHP", 500),
                new PieChart.Data("C#", 500),
                new PieChart.Data("Kotlin",300));
        chart.setData(myData);
    }
}
