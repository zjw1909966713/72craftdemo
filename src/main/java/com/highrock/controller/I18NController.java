package com.highrock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张进文
 * @ClassName I18NController
 * @Description TODO
 * @Date 2020/3/6 15:29
 * @Version 1.0
 */
@RestController
public class I18NController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/i18n")
    public String hello(){
        return messageSource.getMessage("user.name",null, LocaleContextHolder.getLocale());
    }
}
