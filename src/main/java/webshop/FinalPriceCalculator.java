package webshop;


import java.util.List;

public class FinalPriceCalculator {

    public static int calculateFinalPrice(List<Product> basket, String coupon){
        int finalPrice=0;
        for (int i=0;i<basket.size();i++){
            finalPrice+= basket.get(i).getPrice();
        }
        if (coupon.isEmpty()){
            return finalPrice;
        }else if (coupon.equals("ASD")){
            return (int) (finalPrice*0.9);
        }else if (coupon.equals("123")){
            return (int) (finalPrice*0.8);
        }else if (coupon.equals("MMM")){
            return (int) (finalPrice*0.7);
        }
        return finalPrice;
    }
}
