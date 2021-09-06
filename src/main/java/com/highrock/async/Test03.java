package com.highrock.async;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.*;

/**
 * @ClassName: Test03
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/09/03 11:41
 * @Version: 1.0
 */
public class Test03 {
    static AddressService addressService = new AddressService();
    static GoodsService goodsService = new GoodsService();

    public static void main(String[] args) throws Exception {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());
        long begin = System.currentTimeMillis();

        OrderInfo orderInfo = new OrderInfo();

        Future<String> submit1 = executor.submit(() -> {
            String address = addressService.getAddress();
           return address;
        });


        Future<String> submit = executor.submit(() -> {
            String goods = goodsService.getGoods();
           return goods;
        });

        orderInfo.setGoods(submit.get());
        orderInfo.setAddress(submit1.get());


        long end = System.currentTimeMillis();

        System.out.println("花费时间：" + (end - begin) + ",orderInfo=" + JSON.toJSONString(orderInfo));


    }
}
