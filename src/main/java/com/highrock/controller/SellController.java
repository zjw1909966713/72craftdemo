package com.highrock.controller;

import com.highrock.util.BaseJsonRst;
import com.highrock.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张进文
 * @ClassName SellController
 * @Description TODO
 * @Date 2020/3/18 15:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/sell")
public class SellController {

    @Autowired
    private RedisUtil redisUtil;


    private final String PRODUCT_SUM_KEY="productSum";

    @GetMapping("/set")
    public BaseJsonRst set(){
        String res = redisUtil.set(PRODUCT_SUM_KEY, "10");
        return BaseJsonRst.success(res);
    }


    @GetMapping("/get")
    public BaseJsonRst get(){


        int sumStr = Integer.parseInt(redisUtil.get(PRODUCT_SUM_KEY));
        if (sumStr==0){
            return BaseJsonRst.error("已经卖完");
        }
        Long res = redisUtil.decr(PRODUCT_SUM_KEY);
        return BaseJsonRst.success(res);
    }





    public BaseJsonRst sell(){
        return null;
    }
}
