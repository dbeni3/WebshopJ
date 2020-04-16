package hu.unideb.inf;

//import java.awt.*;

public class Product {
    public int price;
    public String productName;
    public String description;
    public String imgSrc;


    public Product(){
    }
    public Product(int price1,String productName1,String description1,String src){
        setPrice(price1);
        setDescription(description1);
        setImgSrc(src);
        setProductName(productName1);
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
