package com.highrock.message;

import com.highrock.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 张进文
 * @ClassName RedisProducer 生产者
 * @Description TODO
 * @Date 2019/5/5 16:54
 * @Version 1.0
 */
@Service
public class RedisProducer {


    @Autowired
    private RedisUtil redisUtil;

    public void sendMessage(String message){
        redisUtil.rpush("USER",message);
        redisUtil.publish("USER",message);
    }

}
