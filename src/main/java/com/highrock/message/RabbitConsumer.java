package com.highrock.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RabbitConsumer
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/07/14 10:20
 * @Version: 1.0
 */
@Component
@Slf4j
public class RabbitConsumer {

    @RabbitListener(queuesToDeclare = @Queue("testMq"))
    public void process(String message){
        log.info("MqReceiver:{}", message);

    }



    /**
     * @description: 订阅模式接受websocket信息,不能写队列名称
     * @author: 张进文
     * @param: [message]
     * @return: void
     * @date: 2020/7/16 15:06
     * @version: 1.0
     */
    @RabbitListener(
            bindings = @QueueBinding(
                    exchange = @Exchange(value = "testmq.fanout", type = ExchangeTypes.FANOUT),
                    value = @Queue())
    )
    public void handlePayWebsocketMessage(String message) throws Exception{
        log.info(" MqReceiver:{}", message);
    }



}
