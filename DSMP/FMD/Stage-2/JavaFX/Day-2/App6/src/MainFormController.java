import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class MainFormController {
    NumberAxis xAxis = new NumberAxis(1,7,1);
    NumberAxis yAxis = new NumberAxis(10,500,20);
    public AreaChart<Number,Number> areaChart = new AreaChart<>(xAxis,yAxis);
    public void initialize(){
        xAxis.setLabel("Day");
        yAxis.setLabel("Student count");
        XYChart.Series javaStudent = new XYChart.Series();
        javaStudent.getData().add(new XYChart.Data(1,150));
        javaStudent.getData().add(new XYChart.Data(2,300));
        javaStudent.getData().add(new XYChart.Data(3,450));
        javaStudent.getData().add(new XYChart.Data(4,500));
        javaStudent.getData().add(new XYChart.Data(5,200));
        javaStudent.getData().add(new XYChart.Data(6,300));
        javaStudent.getData().add(new XYChart.Data(7,50));

        XYChart.Series phpStudent = new XYChart.Series();
        phpStudent.getData().add(new XYChart.Data(1,50));
        phpStudent.getData().add(new XYChart.Data(2,350));
        phpStudent.getData().add(new XYChart.Data(3,400));
        phpStudent.getData().add(new XYChart.Data(4,100));
        phpStudent.getData().add(new XYChart.Data(5,450));
        phpStudent.getData().add(new XYChart.Data(6,120));
        phpStudent.getData().add(new XYChart.Data(7,480));
        areaChart.getData().addAll(phpStudent,javaStudent);

    }
}
