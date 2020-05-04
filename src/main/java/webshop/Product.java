package webshop;

//import java.awt.*;

public class Product {
    int  id;
    public int price;
    public String productName;
    public String description;
    public String imgSrc;

    public Product(int price,String productName,String description,String src){
        this.price=price;
        this.productName=productName;
        this.description=description;
        this.imgSrc=src;
    }
    public Product(int id,int price,String productName,String description,String src){
        this.price=price;
        this.productName=productName;
        this.description=description;
        this.imgSrc=src;
        this.id=id;
    }
    public  int getId(){return  id;}
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
