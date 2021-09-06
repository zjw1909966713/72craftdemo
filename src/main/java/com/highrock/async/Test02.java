package com.highrock.async;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.*;

/**
 * @ClassName: Test02
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/09/03 11:31
 * @Version: 1.0
 */
public class Test02 {
    static AddressService addressService = new AddressService();
    static GoodsService goodsService = new GoodsService();

    public static void main(String[] args) throws Exception {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        long begin = System.currentTimeMillis();

        OrderInfo orderInfo = new OrderInfo();

        CompletableFuture<Void> addressFu=CompletableFuture.runAsync(()->{
            String address = addressService.getAddress();
            orderInfo.setAddress(address);
        },executor);


        CompletableFuture<Void> goodsFu=CompletableFuture.runAsync(()->{
            String goods = goodsService.getGoods();
            orderInfo.setGoods(goods);
        },executor);

       CompletableFuture.allOf(addressFu, goodsFu).get();


        long end = System.currentTimeMillis();

        System.out.println("花费时间：" + (end - begin) + ",orderInfo=" + JSON.toJSONString(orderInfo));


    }
}
