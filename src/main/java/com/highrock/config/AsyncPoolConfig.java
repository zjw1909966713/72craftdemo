package com.highrock.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 张进文
 * @ClassName AsyncPoolConfig
 * @Description 自定义
 * @Date 2020/5/19 11:13
 * @Version 1.0
 */
@Slf4j
@Configuration
public class AsyncPoolConfig implements AsyncConfigurer {

    @Bean
    @Override
    public Executor getAsyncExecutor() {

        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
//        Executors.newSingleThreadExecutor()

        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(20);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("ImoocAsync_");

        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        //拒绝策略
        executor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy()
        );



        executor.initialize();
      return executor;
    }

    /** *
     * @description: 定义异步任务异常处理类
     * @author: 张进文
     * @param: []
     * @return: org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
     * @date: 2020/5/19 13:21
     * @version: 1.0
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }

    class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("AsyncError:{},Method:{},Param:{}",throwable.getMessage(),method.getName(), JSON.toJSONString(objects));
            throwable.printStackTrace();
            //TODO

        }
    }
}
