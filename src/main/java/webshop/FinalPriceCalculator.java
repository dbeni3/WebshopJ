package webshop;


import org.tinylog.Logger;
import java.util.List;


public class FinalPriceCalculator {

    public static int calculateFinalPrice(List<Product> basket, String coupon){
        int finalPrice=sumPrice(basket);
        if (checkPrice(finalPrice)){
            finalPrice=1;
            return finalPrice;
        }
        if (coupon.isEmpty() ){
            Logger.info("coupon not found");
            return finalPrice;
        }else if (coupon.equalsIgnoreCase("ASD")){
            return (int) (finalPrice*0.9);
        }else if (coupon.equals("123")){
            return (int) (finalPrice*0.8);
        }else if (coupon.equalsIgnoreCase("MMM")){
            return (int) (finalPrice*0.7);
        }
        Logger.info("Wrong coupon code");
        return finalPrice;
    }
    public static int sumPrice(List<Product> basket){
        int finalPrice=0;
        for (int i=0;i<basket.size();i++){
            finalPrice+= basket.get(i).getPrice();
        }
        return finalPrice;
    }
    public static boolean checkPrice(int price){
        if (price<1){
            Logger.error("Invalid price");
            return true;
        }else return false;
    }
}
