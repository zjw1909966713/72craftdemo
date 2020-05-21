package com.highrock.service;

import com.highrock.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 张进文
 * @ClassName AsyncServiceTest
 * @Description TODO
 * @Date 2020/5/19 13:38
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AsyncServiceTest {

    @Resource
    private AsyncService asyncService;


    @Test
    public void testAsyncProcess() throws InterruptedException{
        asyncService.asyncProcess();
        log.info("test");
    }


}
