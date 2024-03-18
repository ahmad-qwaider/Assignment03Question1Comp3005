module com.example.assignment01comp3005 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.assignment01comp3005 to javafx.fxml;
    exports com.example.assignment01comp3005;
}