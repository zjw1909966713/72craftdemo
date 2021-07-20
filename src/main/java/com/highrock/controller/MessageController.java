package com.highrock.controller;

import com.alibaba.fastjson.JSON;
import org.joda.time.DateTime;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MessageController
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/07/14 10:18
 * @Version: 1.0
 */
@RestController
@RequestMapping("/mess")
public class MessageController {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RequestMapping("/send")
    public void send(String message){
        Map<String,Object> map=new HashMap<>();
        map.put("time", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        map.put("message",message);
        rabbitTemplate.convertAndSend("testMq", JSON.toJSONString(map));


    }


    @RequestMapping("/send1")
    public void send1(String message){
        Map<String,Object> map=new HashMap<>();
        map.put("time", new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        map.put("message",message);
        map.put("code",Math.random());
        rabbitTemplate.convertAndSend("testmq.fanout","",JSON.toJSONString(map));


    }


}
