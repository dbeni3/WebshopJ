package hu.unideb.inf;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML
    private Label productDes1;
    @FXML
    private Label productDes2;
    @FXML
    private Label productDes3;
    @FXML
    private Label productDes4;
    @FXML
    private Label productDes5;
    @FXML
    private Label productDes6;
    @FXML
    private Label productName1;
    @FXML
    private Label productName2;
    @FXML
    private Label productName3;
    @FXML
    private Label productName4;
    @FXML
    private Label productName5;
    @FXML
    private Label productName6;
    @FXML
    private Label price1;
    @FXML
    private Label price2;
    @FXML
    private Label price3;
    @FXML
    private Label price4;
    @FXML
    private Label price5;
    @FXML
    private Label price6;
    @FXML
    private ImageView productImg1;
    @FXML
    private ImageView productImg2;
    @FXML
    private ImageView productImg3;
    @FXML
    private ImageView productImg4;
    @FXML
    private ImageView productImg5;
    @FXML
    private ImageView productImg6;




    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }


}
