package com.highrock.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.highrock.service.DemoService;
import com.highrock.util.Freemark;
import com.highrock.util.FreemarkUtil;
import com.highrock.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DemoServiceImpl implements DemoService {


    @Value("${stripe_api_key}")
    private String testKey;

    @Override
    public void test1() {
        System.out.println("test1============================="+testKey);
        System.out.println("test2============================="+ PropertiesUtil.stripe_api_key);

        Map<String,Object> map=new HashMap<>();

        List<JSONObject> list=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("name","4566");
            jsonObject.put("age",i);
            list.add(jsonObject);
        }
        map.put("userlist",list);

        String aa=FreemarkUtil.createHtml("qrd.ftl",map);
        System.out.println(aa);



    }


    @Override
    //@Scheduled(cron = "0/1 * * * * ?")
    public void test2() {
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }
}
