package Webshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.FinalPriceCalculator;
import webshop.Orders;
import webshop.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalPriceCalculatorTest {
    private List<Product> basket=new ArrayList<Product>();

    @BeforeEach
    public void init(){
        basket.add(new Product(100,"name","desc","img"));
        basket.add(new Product(1,10,"name","desc","img"));
    }


    @Test
    public void testSumPrice(){
        assertEquals(110, FinalPriceCalculator.sumPrice(basket));
    }

    @Test
    public void testCheckpricetrue(){
        int price=0;
        assertEquals(true, FinalPriceCalculator.checkPrice(price));
    }
    @Test
    public void testCheckpricefals(){
        int price=110;
        assertEquals(false, FinalPriceCalculator.checkPrice(price));
    }
    @Test
    public void testCalculateFinalPriceWithoutCoupon(){
        String coupon="";

        assertEquals(110, FinalPriceCalculator.calculateFinalPrice(basket,coupon));
    }
    @Test
    public void testCalculateFinalPriceWithoutCouponWrongPrice(){
        String coupon="";
        basket.add(new Product(-210,"name","desc","img"));
        assertEquals(1, FinalPriceCalculator.calculateFinalPrice(basket,coupon));
    }
    @Test
    public void testCalculateFinalPriceinvalidCoupon(){
        String coupon="jfh";
        assertEquals(110, FinalPriceCalculator.calculateFinalPrice(basket,coupon));
    }
    @Test
    public void testCalculateFinalPriceFirstCouponUppercase(){
        String coupon="ASD";
        assertEquals(99, FinalPriceCalculator.calculateFinalPrice(basket,coupon));
    }
    @Test
    public void testCalculateFinalPriceFirstCouponLowercase(){
        String coupon="asd";
        assertEquals(99, FinalPriceCalculator.calculateFinalPrice(basket,coupon));
    }
    @Test
    public void testCalculateFinalPriceSecondCoupon(){
        String coupon="123";
        assertEquals(88, FinalPriceCalculator.calculateFinalPrice(basket,coupon));
    }
    @Test
    public void testCalculateFinalPriceThirdCouponUppercase(){
        String coupon="MMM";
        assertEquals(77, FinalPriceCalculator.calculateFinalPrice(basket,coupon));
    }
    @Test
    public void testCalculateFinalPriceThirdCouponLowercase(){
        String coupon="MMM";
        assertEquals(77, FinalPriceCalculator.calculateFinalPrice(basket,coupon));
    }





}
