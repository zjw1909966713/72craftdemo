package com.highrock.controller;

import com.highrock.util.BaseJsonRst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/demo")
public class DemoConroller {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    //定义资源的总数量
    Semaphore semaphore=new Semaphore(1);




    @Resource(name = "appServiceExecutor")
    private ThreadPoolTaskExecutor excutor;

    @GetMapping("/test")
    public String test(){
        logger.info("============================");
        int avaliablePermits=semaphore.availablePermits();
        if (avaliablePermits>0){
            logger.info("===============================抢到资源");
        }else{
            logger.info("资源已被占用，请稍后再试");
            return "Resource is busy";

        }


        try {
            semaphore.acquire(1);
            logger.info("资源正在使用");
            //放大资源占用时间，便于观察
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release(1);
        }

        return "hello world,success";
    }

    @GetMapping("/sync")
    public BaseJsonRst testSync(){
        long startTime=System.currentTimeMillis();

        List<String> list=new ArrayList<>(4);
        list.add(test1());
        list.add(test2());
        list.add(test3());
        list.add(test4());
        logger.info("总耗时:{}ms",System.currentTimeMillis()-startTime);
        return BaseJsonRst.success(list);

    }

    @GetMapping("/async")
    public BaseJsonRst testAsync(){
        long startTime=System.currentTimeMillis();

        Future<String> test1Future = excutor.submit(this::test1);
        Future<String> test2Future = excutor.submit(this::test2);
        Future<String> test3Future = excutor.submit(this::test3);
        Future<String> test4Future = excutor.submit(this::test4);

        List<Future<String>> futureList= Arrays.asList(test1Future,test2Future,test3Future,test4Future);

        List<String> list =futureList.stream().map((future)->{
            try {
               // logger.info("");
                return future.get();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        logger.info("总耗时:{}ms",System.currentTimeMillis()-startTime);
        return BaseJsonRst.success(list);
    }


    @GetMapping("/async1")
    public BaseJsonRst testAsync1(@RequestParam(name = "sum",defaultValue = "20") int sum){
        long startTime=System.currentTimeMillis();

        logger.info("核心数{}",Runtime.getRuntime().availableProcessors());
        List<Future<String>> futureList=new ArrayList<>();
        for (int i = 0; i < sum; i++) {
            int a=i;
            Future<String> test1Future = excutor.submit(()->tes(a));
            futureList.add(test1Future);
        }

        List<String> list =futureList.stream().map(future->{
            try {
                return future.get();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
        long time=System.currentTimeMillis()-startTime;
        logger.info("总耗时:{}ms",time);

        return BaseJsonRst.success(String.valueOf(time),list);
    }




    private String tes(int i){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "tes"+i;
    }



    private String test1(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test1";

    }

    private String test2(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test2";

    }

    private String test3(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test3";

    }

    private String test4(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test4";

    }

    private BaseJsonRst deomoTest(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return BaseJsonRst.error(e.getMessage());
        }
        return BaseJsonRst.success();

    }






}
