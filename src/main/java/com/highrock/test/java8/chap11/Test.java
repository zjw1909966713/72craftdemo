package com.highrock.test.java8.chap11;

import java.util.concurrent.Future;

/**
 * @ClassName: Test
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/19 14:58
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
         Shop shop=new Shop("BestShop");
        long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsnc("my favorite product");

        long invocationTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Invocation returned after "+invocationTime+" msecs");


        try {
            double price = futurePrice.get();
            System.out.printf("price is %.2f%n",price);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        long retrievalTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Price returned after "+retrievalTime+" msecs");

    }
}
