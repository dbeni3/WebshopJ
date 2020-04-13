package hu.unideb.inf;

public class product {
    public int price=0;
    public String productName="";
    public String description="";
    public String imgSrc="";
    public void product(){
        price=100;
        productName="monitor";
        description="Vedd meg jó lesz";
        imgSrc="img/img1.jpg";
    }
    public void product(int pricein,String productNamein,String descriptionin,String imgSrcin){
        price=pricein;
        productName=productNamein;
        description=descriptionin;
        imgSrc=imgSrcin;
    }

    @Override
    public String toString() {
        return productName;
    }
}
