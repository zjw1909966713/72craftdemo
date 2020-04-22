package com.highrock.message;

import com.highrock.service.RedisLock;
import com.highrock.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author 张进文
 * @ClassName RedisConsumer 消费者
 * @Description TODO
 * @Date 2019/5/5 16:58
 * @Version 1.0
 */
@Component
@Slf4j
public class RedisConsumer {


    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisLock redisLock;


    public void receiveMessage(String mess) {

        //防止信息被二次消费
        String message= redisUtil.lpop("USER");
//        String message=mess;
        if(StringUtils.isEmpty(message)){
            return;
        }
        log.info("收到的mq消息" + message);





    }

}
