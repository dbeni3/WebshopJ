package controller;

import db.JPA;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;
import webshop.FinalPriceCalculator;
import webshop.Orders;
import webshop.Product;
import main.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import webshop.Purchaser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ForkJoinPool;

public class OrderController implements Initializable {
    @FXML
    TextField purchaserName;
    @FXML
    TextField purchaserPostalCode;
    @FXML
    TextField purchaserAddress;
    @FXML
    TextField purchaserPhone;
    @FXML
    TextField purchaserEmail;
    @FXML
    TextField couponText;

    @FXML
    Label finalPricelabel;
    @FXML
    Label couponMess;
    private List<Product> basket=new ArrayList<Product>();
    private int finalPrice;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        basket= ShopController.basket;
        finalPrice= FinalPriceCalculator.calculateFinalPrice(basket,"");
        finalPricelabel.setText("Végösszeg: " + finalPrice);
    }
    @FXML
    private void coupon(){
        int priceWithCoupon=FinalPriceCalculator.calculateFinalPrice(basket,couponText.getText());
        if (finalPrice!=priceWithCoupon && finalPrice!=-1){
            couponMess.setText("Kupon aktiválva!");
            couponMess.setVisible(true);
            finalPricelabel.setText("Végösszeg: "  + priceWithCoupon);
            finalPrice=-1;
            Logger.info("Coupon was used");
        }else{
            couponMess.setText("Hibás Kupon");
            couponMess.setVisible(true);
            Logger.info("Coupon was wrong");
        }
    }
    @FXML
    private void makeOrder(ActionEvent actionEvent) throws IOException {

        Purchaser purchaser=new Purchaser(purchaserName.getText(),purchaserPhone.getText(),purchaserEmail.getText(),purchaserPostalCode.getText(),purchaserAddress.getText());
        JPA.createPurcasher(purchaser);
        Logger.info("Purchaser was registered");
        List<Purchaser> p=JPA.getLastPurchaser();
        long purchaserId=p.get(p.size()-1).getID();
        List<Orders> orders=new ArrayList<Orders>();
        for (int i=0;i<basket.size();i++){
            orders.add(new Orders(basket.get(i).getId(),purchaserId));
        }
        for (int i=0;i<orders.size();i++){
            JPA.createOrders(orders.get(i));
        }
        Logger.info("Orders was registered");
        ShopController.basket.clear();
        Parent root = FXMLLoader.load(getClass().getResource("/xml/shop.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("Loading shop scene");
    }

}