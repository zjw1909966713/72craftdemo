package com.highrock.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author 张进文
 * @ClassName AsyncService
 * @Description <h1>异步处理服务</h1>
 * @Date 2020/5/19 11:07
 * @Version 1.0
 */
@Slf4j
@Service
public class AsyncService {


    @Async("getAsyncExecutor")
    public void asyncProcess() throws InterruptedException{
        log.info("async process task, current thread name ->{}",Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
    }


    @Async("getAsyncExecutor")
    public Future<Integer> asyncProcessHasReturn() throws  InterruptedException{
        log.info("async process task(has return), current thread name ->{}",Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        return new AsyncResult<>(100);

    }
}
