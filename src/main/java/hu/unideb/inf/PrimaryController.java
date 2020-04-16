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

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {
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
    private int from=0;
    public void readFromJson()  {
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
    public void writeToJson() {
        try {
            List<Product> products = Arrays.asList(
                  new Product(100,"alma","Szepaghdfghlma","img/img1.jpg"),
                    new Product(101,"alma","Szepdghdalma","img/motor2.jpg"),
                    new Product(120,"alma","Szepdfghhdgfflma","img/motor.png"),
                    new Product(150,"alma","Szepaldfgdgma","img/motor2.jpg"),
                    new Product(180,"alma","Szephdfghdgfdalma","img/motor.png"),
                    new Product(10,"alma","Szepgdalma","img/motor3.jpg"),
                    new Product(1470,"alma","Szepgdaljhghjkma","img/motor2.jpg"),
                    new Product(12054,"alma","Szepdfghhdgfflma","img/motor2.jpg"),
                    new Product(14750,"alma","Szepaldfgdgma","img/motor2.jpg"),
                    new Product(1215,"alma","Szephdfghdgfdalma","img/motor2.jpg"),
                    new Product(184,"alma","Szepgdalma","img/motor3.jpg"),
                    new Product(101324,"alma","Szepdghdalma","img/motor2.jpg"),
                    new Product(125620,"alma","Szepdfghhdgfflma","img/motor3.jpg"),
                    new Product(1574230,"alma","Szepaldfgdgma","img/motor.png"),
                    new Product(185420,"alma","Szephdfghdgfdalma","img/motor2.jpg"),
                    new Product(178950,"alma","Szepgdalma","img/motor2.jpg"),
                    new Product(146570,"alma","Szepgdaljhghjkma","img/motor3.jpg"),
                    new Product(120654,"alma","Szepdfghhdgfflma","img/motor.png"),
                    new Product(1475430,"alma","Szepaldfgdgma","img/motor2.jpg"),
                    new Product(123215,"alma","Szephdfghdgfdalma","img/motor.png"),
                    new Product(1824564,"alma","Szepgdalma","img/motor2.jpg")
            );
            Writer writer = new FileWriter(new File("src/main/resources/hu/unideb/inf/Jsons/Products.json"));
            new Gson().toJson(products, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    public void addToCart(ActionEvent actionEvent) {
        for (int i=0;i<buttons.size();i++){
            if(actionEvent.getSource()==buttons.get(i)){
                System.out.println(prices.get(i).getText());
            }
        }
    }
    public void setTextOnView(int from){
        if (products.size()-6<from){
            from=products.size()-6;
            DropShadow shadow = new DropShadow();
            nextButton.setEffect(shadow);
        }else if (from==0){
            DropShadow shadow = new DropShadow();
            backButton.setEffect(shadow);
        }
        for (int i=0;i<6;i++){
            prices.get(i).setText("" + products.get(i+from).getPrice());
        }
        for (int i=0;i<6;i++){
            names.get(i).setText(products.get(i+from).getProductName());
        }
        for (int i=0;i<6;i++){
            des.get(i).setText(products.get(i+from).getDescription());
        }
        for (int i=0;i<6;i++){
            Image image=new Image(getClass().getResourceAsStream(products.get(i+from).getImgSrc()));
            imageViews.get(i).setImage(image);
        }
    }
    public void nextPage(ActionEvent actionEvent){
        if (products.size()-6<from){
            from=products.size()-6;
        }else {
            from=from+6;
        }
        setTextOnView(from);
    }
    public void backPage(ActionEvent actionEvent){
        if (from-6<0){
            from=0;
        }else {
            from=from-6;
        }
        setTextOnView(from);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       writeToJson();
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
            File file =new File("src/main/resources/hu/unideb/inf/Jsons/Products.json");
            Reader reader = Files.newBufferedReader(Paths.get(file.getPath()));
            products = new Gson().fromJson(reader, new TypeToken<List<Product>>() {}.getType());
            setTextOnView(from);
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }
}
