package com.highrock.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.highrock.vo.Imoocer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 张进文
 * @ClassName JacksonController
 * @Description jackson
 * @Date 2020/5/19 14:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/jackson")
@Slf4j
public class JacksonController {


    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/jackson")
    public Imoocer jackson() throws Exception{

        Imoocer imoocer=Imoocer.builder().name("zhangjinwe").age(23).address("天津市津南区辛庄镇").registerTime(new Date()).build();


        String jsonImoocer=objectMapper.writeValueAsString(imoocer);
        log.info("imoocer jackson:{}",jsonImoocer);
        return objectMapper.readValue(jsonImoocer,Imoocer.class);

//        return imoocer;

    }


}
