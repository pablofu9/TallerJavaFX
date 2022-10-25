module com.mycompany.practica2fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens com.mycompany.practica2fx to javafx.fxml;
    exports com.mycompany.practica2fx;
}
