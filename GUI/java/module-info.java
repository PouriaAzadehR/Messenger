module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo3 to javafx.fxml;
    exports com.example.demo3;
    exports com.company.ap.server.services;
    opens com.company.ap.server.services to javafx.fxml;
    exports com.company.ap.server;
    opens com.company.ap.server to javafx.fxml;
    exports com;
    opens com to javafx.fxml;
}