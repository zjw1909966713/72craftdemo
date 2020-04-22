package com.highrock.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


/** *
 * @description: TODO
 * @author: 张进文
 * @param:
 * @return: 
 * @date: 2020/3/3 9:10
 * @version: 1.0
 */
@Slf4j
@Configuration
@EnableAsync
public class ExecutorConfig {
    private final static String THREAD_NAME_PREFIX="app-async-service-";

    @Value("20")
    private int corePoolSize;

    @Value("50")
    private int maxPoolSize;


    @Value("1000")
    private int queueCapacity;

    @Value("3000")
    private int keepAliveSeconds;

    @Bean
    public ThreadPoolTaskExecutor appServiceExecutor(){
        ThreadPoolTaskExecutor executor=new AppThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        log.info("thread pool executor initialized");
        return executor;

    }
}
