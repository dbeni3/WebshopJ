module hu.unideb.inf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;


    opens hu.unideb.inf to javafx.fxml;
    exports hu.unideb.inf;
}