package hu.unideb.inf;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

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
    private Button nextButton;
    @FXML
    private Button backButton;
    private  List<ImageView> imageViews= new ArrayList<>();
    private  List<Button> buttons= new ArrayList<>();
    private List<Product> products=new ArrayList<>();
    private List<Product> basket=new ArrayList<>();
    private List<Product> track=new ArrayList<>();
    private int from=0;
    private void readFromJson()  {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("Products.json"));
            List<Product> products = new Gson().fromJson(reader, new TypeToken<List<Product>>() {}.getType());
            products.forEach(System.out::println);
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void writeToJson() {
        try {
            List<Product> products = Arrays.asList(

            );
            Writer writer = new FileWriter(new File("src/main/resources/hu/unideb/inf/Jsons/Products.json"));
            new Gson().toJson(products, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    private void switchToOrder() throws IOException {
        App.setRoot("order");
    }
    @FXML
    private void addToCart(ActionEvent actionEvent) {
        for (int i=0;i<buttons.size();i++){
            if(actionEvent.getSource()==buttons.get(i)){
               basket.add(track.get(i));
            }
        }
    }
    private void setTextOnShop(int from){
        if (products.size()-6<from){
            from=products.size()-6;
            setButtonDisable(nextButton);
        }else if (from==0){
            setButtonDisable(backButton);
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
            Image image=new Image(getClass().getResourceAsStream(products.get(i+from).getImgSrc()));
            imageViews.get(i).setImage(image);
        }
    }
    private void setTextOnBasket(int from){
        if (basket.size()-3<from){
            from=basket.size()-3;
            if (from<0){
                from=0;
            }
            //setButtonDisable(nextButton);
        }else if (from==0){
           // setButtonDisable(backButton);
        }
        for (int i=0;i<3 && i<basket.size();i++){
            basketPrices.get(i).setText("" + basket.get(i+from).getPrice());
        }
        for (int i=0;i<3 && i<basket.size();i++){
            basketName.get(i).setText(basket.get(i+from).getProductName());
        }
    }
    @FXML
    private void nextPage(ActionEvent actionEvent){
        if (products.size()-6<from){
            from=products.size()-6;
        }else {
            from=from+6;
            setButtonEnable(backButton);
        }
        setTextOnShop(from);
    }
    @FXML
    private void backPage(ActionEvent actionEvent){
        if (from-6<0){
            from=0;
        }else {
            from=from-6;
            setButtonEnable(nextButton);
        }
        setTextOnShop(from);
    }
    @FXML
    private void toBasketPane() {
        setTextOnBasket(0);
        shopPane.setDisable(true);
        basketPane.setVisible(true);
    }
    @FXML
    private void toShopPane() {

        shopPane.setDisable(false);
        basketPane.setVisible(false);
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       JsonWriter.fillJson();
        basketPane.setVisible(false);
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
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/hu/unideb/inf/Jsons/Products.json"));
            products = new Gson().fromJson(reader, new TypeToken<List<Product>>() {}.getType());
            for (int i=0;i<6 && i<products.size();i++){
                track.add(products.get(i));
            }
            setTextOnShop(from);
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
