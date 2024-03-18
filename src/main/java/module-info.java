module com.example.assignment01comp3005 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens Assignment03Question1Comp3005 to javafx.fxml;
    exports Assignment03Question1Comp3005;
}