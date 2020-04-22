package com.highrock.demo;

import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张进文
 * @ClassName Test5
 * @Description TODO
 * @Date 2020/4/9 13:17
 * @Version 1.0
 */
public class Test5 {
    public static void main(String[] args) {
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("name","zhang");
        dataMap.put("age",25);
        dataMap.put("created",new DateTime().toString("yyyy-MM-dd HH:mm:ss"));


        for(Map.Entry a:dataMap.entrySet()){
            System.out.println(a.getKey()+":"+a.getValue());
        }
       String a= "{ \"imgName\": \"myFirstUpload\", \"labNo\": \"G001\", \"labType\": 2, \"userId\": 121 }";
    }
}
