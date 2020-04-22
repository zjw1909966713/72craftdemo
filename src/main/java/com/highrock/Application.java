package com.highrock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 * @description: TODO
 * @author: 张进文
 * @param:
 * @return:
 * @date: 2018/11/28 10:38
 * @version: 1.0
 */
@SpringBootApplication
//开启调度
@EnableScheduling

//开swagger
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
