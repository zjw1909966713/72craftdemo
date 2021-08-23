package com.highrock.test.java8.chap11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @ClassName: Chap11
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/19 13:48
 * @Version: 1.0
 */
public class Shop {


    private  String name;

    public static void delay(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public double getPrice(String product){
        return calculatePrice(product);
    }

    private double calculatePrice(String product){
        delay();
        return new Random().nextDouble()*product.charAt(0)+product.charAt(1);
    }

    public Future<Double> getPriceAsnc(String product){
        CompletableFuture<Double> futurePrice=new CompletableFuture<>();
        new Thread(()->{
            double price=calculatePrice(product);
            futurePrice.complete(price);
        }).start();

        return futurePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop(String name) {
        this.name = name;
    }
}
