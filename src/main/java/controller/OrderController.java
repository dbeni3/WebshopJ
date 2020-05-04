package controller;

import webshop.FinalPriceCalculator;
import webshop.Product;
import db.Db;
import main.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
        }else{
            couponMess.setText("Hibás Kupon");
            couponMess.setVisible(true);
        }
    }
    @FXML
    private void makeOrder() throws IOException {

        Db db =new Db();
        db.addPurchaser(purchaserName.getText(),purchaserPhone.getText(),purchaserEmail.getText(),purchaserPostalCode.getText(),purchaserAddress.getText());
        int purchaserID=db.getPurchaser();
        for (int i=0;i<basket.size();i++){
            db.addOrder(purchaserID,basket.get(i).getId());
        }
        ShopController.basket.clear();
        App.setRoot("shop");
    }

}