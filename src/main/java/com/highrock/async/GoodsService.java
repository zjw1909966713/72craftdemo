package com.highrock.async;

/**
 * @ClassName: GoodsService
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/09/03 11:16
 * @Version: 1.0
 */
public class GoodsService {

    public String getGoods()  {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "apple";
    }
}
