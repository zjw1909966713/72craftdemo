package com.highrock.async;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;

/**
 * @ClassName: Test01
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/09/03 11:17
 * @Version: 1.0
 */
public class Test01 {

     static AddressService addressService=new AddressService();
     static GoodsService goodsService=new GoodsService();

    public static void main(String[] args) {
        long begin=System.currentTimeMillis();

        OrderInfo orderInfo=new OrderInfo();


        String address = addressService.getAddress();
        orderInfo.setAddress(address);

        String goods=goodsService.getGoods();
        orderInfo.setGoods(goods);

        long end=System.currentTimeMillis();

        System.out.println("花费时间："+(end-begin)+",orderInfo="+ JSON.toJSONString(orderInfo));






    }
}
