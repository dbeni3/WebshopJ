package hu.unideb.inf;

import javafx.fxml.FXML;

import java.io.IOException;

public class OrderController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("shop");
    }
}