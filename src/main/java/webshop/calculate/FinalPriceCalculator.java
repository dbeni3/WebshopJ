package webshop.calculate;


import org.tinylog.Logger;
import webshop.objects.Product;

import java.util.List;

/**
 * Class for calculate {@code finalPrice}
 */
public class FinalPriceCalculator {
    /**
     * Return the {@code finalPrice} with respect to the coupon.
     *
     * @param basket is the list of products.
     * @param coupon is the string of coupon code.
     * @return the {@code finalPrice} with respect to the coupon
     */
    public static int calculateFinalPrice(List<Product> basket, String coupon) {
        int finalPrice = sumPrice(basket);
        if (checkPrice(finalPrice)) {
            finalPrice = 1;
            return finalPrice;
        }
        if (coupon.isEmpty()) {
            Logger.info("coupon not found");
            return finalPrice;
        } else if (coupon.equalsIgnoreCase("ASD")) {
            return (int) (finalPrice * 0.9);
        } else if (coupon.equals("123")) {
            return (int) (finalPrice * 0.8);
        } else if (coupon.equalsIgnoreCase("MMM")) {
            return (int) (finalPrice * 0.7);
        }
        Logger.info("Wrong coupon code");
        return finalPrice;
    }

    /**
     * Return the {@code sumPrice}, the sum of the prices of the products.
     *
     * @param basket is the list of products.
     * @return the {@code sumPrice}, the sum of the prices of the products
     */
    public static int sumPrice(List<Product> basket) {
        int sumPrice = 0;
        for (int i = 0; i < basket.size(); i++) {
            sumPrice += basket.get(i).getPrice();
        }
        return sumPrice;
    }

    /**
     * Check the price is valid .
     *
     * @param price is the list of products.
     * @return boolean, depending on the price
     */
    public static boolean checkPrice(int price) {
        if (price < 1) {
            Logger.error("Invalid price");
            return true;
        } else return false;
    }
}
