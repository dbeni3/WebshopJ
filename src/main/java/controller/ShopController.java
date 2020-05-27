package controller;

import db.JPA;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;
import webshop.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.StrictMath.abs;

public class ShopController implements Initializable {
    @FXML
    private Pane basketPane;
    @FXML
    private BorderPane shopPane;
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
    private  List<Label> des= new ArrayList<>();
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
    private  List<Label> names= new ArrayList<>();
    @FXML
    private Label basketProdName1;
    @FXML
    private Label basketProdName2;
    @FXML
    private Label basketProdName3;
    private  List<Label> basketName= new ArrayList<>();
    @FXML
    private Label basketProdPrice1;
    @FXML
    private Label basketProdPrice2;
    @FXML
    private Label basketProdPrice3;
    private  List<Label> basketPrices= new ArrayList<>();
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
    private  List<Label> prices= new ArrayList<>();
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
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button1;
    @FXML
    private Button delete1;
    @FXML
    private Button delete2;
    @FXML
    private Button delete3;
    @FXML
    private Button nextButtonOnPage;
    @FXML
    private Button backButtonOnPage;
    @FXML
    private Button nextButtonOnBasket;
    @FXML
    private Button backButtonOnBasket;
    private  List<ImageView> imageViews= new ArrayList<>();
    private  List<Button> buttons= new ArrayList<>();
    private  List<Button> deleteButtons= new ArrayList<>();
    private List<Product> products=new ArrayList<>();
    public static List<Product> basket=new ArrayList<>();
    private List<Product> track=new ArrayList<>();
    private int fromPage =0;
    private int fromBasket=0;
    @FXML
    private void switchToOrder(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/xml/order.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("Loading order scene");
    }
    @FXML
    private void addToCart(ActionEvent actionEvent) {
        for (int i=0;i<buttons.size();i++){
            if(actionEvent.getSource()==buttons.get(i)){
               basket.add(track.get(i));
            }
        }
        Logger.info("Product was added to cart");
    }
    private void setTextOnShop(int from){
        if (products.size()-6<from){
            from=products.size()-6;
            setButtonDisable(nextButtonOnPage);
        }else if (from==0){
            setButtonDisable(backButtonOnPage);
        }
        for (int i=0;i<6 && i< products.size();i++){
            track.set(i,products.get(i+from));
        }
        for (int i=0;i<6 && i< products.size();i++){
            prices.get(i).setText("" + products.get(i+from).getPrice());
        }
        for (int i=0;i<6 && i< products.size();i++){
            names.get(i).setText(products.get(i+from).getProductName());
        }
        for (int i=0;i<6 && i< products.size();i++){
            des.get(i).setText(products.get(i+from).getDescription());
        }
        for (int i=0;i<6 && i< products.size();i++){
            Image image=new Image(getClass().getClassLoader().getResourceAsStream(products.get(i+from).getImgSrc()));
            imageViews.get(i).setImage(image);
        }
    }
    private void setTextOnBasket(int from){
        int to=3;

        if (from<0){
            fromBasket=0;
            return;
        }
        if (from<=3 && basket.size()<3){
            setButtonDisable(nextButtonOnBasket);
            setButtonDisable(backButtonOnBasket);
        }
        if (basket.size()>3){
            setButtonEnable(nextButtonOnBasket);
        }
        if (from>basket.size()){
            setButtonDisable(nextButtonOnBasket);
            fromBasket=basket.size();
            return;
        }
        if (from>basket.size()-3){
           to= abs(from-basket.size());
        }
        for (int i=0; i<3;i++){
            setButtonEnable(deleteButtons.get(i));
        }
        if (to<3){
            for (int i=to;i<3;i++){
                setButtonDisable(deleteButtons.get(i));
            }
        }
        for (int i=0;i<to && i<3;i++){
            basketPrices.get(i).setText("" + basket.get(i+from).getPrice());
        }
        if (to<3){
            for (int i=to;i<3;i++){
                basketPrices.get(i).setText("xxx");
            }
        }
        for (int i=0;i<to && i<3;i++){
            basketName.get(i).setText(basket.get(i+from).getProductName());
        }
        if (to<3){
            for (int i=to;i<3;i++){
                basketName.get(i).setText("xxx");
            }
        }
    }
    @FXML
    private void nextPage(){
        if (products.size()-6< fromPage){
            fromPage =products.size()-6;
        }else {
            fromPage = fromPage +6;
           setButtonEnable(backButtonOnPage);
        }
        setTextOnShop(fromPage);
    }
    @FXML
    private void backPage(){
        if (fromPage -6<0){
            fromPage =0;
        }else {
            fromPage = fromPage -6;
           setButtonEnable(nextButtonOnPage);
        }
        setTextOnShop(fromPage);
    }
    @FXML
    private void toBasketPane() {
        if (basket.size()>3){
            setButtonEnable(nextButtonOnBasket);
        }
        setTextOnBasket(fromBasket);
        shopPane.setDisable(true);
        basketPane.setVisible(true);
        Logger.info("Basket is visible");
    }
    @FXML
    private void toShopPane() {
        shopPane.setDisable(false);
        basketPane.setVisible(false);
        Logger.info("Shop pane is visible");
    }
    private void setButtonDisable(Button button){
        DropShadow shadow = new DropShadow();
        button.setEffect(shadow);
        button.setDisable(true);
    }
    private void setButtonEnable(Button button){
        button.setEffect(null);
        button.setDisable(false);
    }
    @FXML
    private void deleteButton(ActionEvent actionEvent){
        for (int i=0;i<deleteButtons.size();i++){
            if(actionEvent.getSource()==deleteButtons.get(i)){
                if (basket.size()!=0){
                    basket.remove(i);
                }
                fromBasket=0;
                setTextOnBasket(0);
            }
        }
        Logger.info("Product was removed from cart");
    }
    @FXML
    private void backOnBasketButton(ActionEvent actionEvent){
        fromBasket-=3;
        setTextOnBasket(fromBasket);
        setButtonEnable(nextButtonOnBasket);
    }
    @FXML
    private void nextOnBasketButton(ActionEvent actionEvent){
        fromBasket+=3;
        setButtonEnable(backButtonOnBasket);
        setTextOnBasket(fromBasket);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        basketPane.setVisible(false);
        deleteButtons.forEach(this::setButtonDisable);
        basketName.add(basketProdName1);
        basketName.add(basketProdName2);
        basketName.add(basketProdName3);
        basketPrices.add(basketProdPrice1);
        basketPrices.add(basketProdPrice2);
        basketPrices.add(basketProdPrice3);
        prices.add(price1);
        prices.add(price2);
        prices.add(price3);
        prices.add(price4);
        prices.add(price5);
        prices.add(price6);
        names.add(productName1);
        names.add(productName2);
        names.add(productName3);
        names.add(productName4);
        names.add(productName5);
        names.add(productName6);
        des.add(productDes1);
        des.add(productDes2);
        des.add(productDes3);
        des.add(productDes4);
        des.add(productDes5);
        des.add(productDes6);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        imageViews.add(productImg1);
        imageViews.add(productImg2);
        imageViews.add(productImg3);
        imageViews.add(productImg4);
        imageViews.add(productImg5);
        imageViews.add(productImg6);
        deleteButtons.add(delete1);
        deleteButtons.add(delete2);
        deleteButtons.add(delete3);
        products=JPA.getProducts();
        Logger.info("Reading Products");
        for (int i=0;i<6 && i<products.size();i++){
            track.add(products.get(i));
        }
        setTextOnShop(fromPage);
    }
}
