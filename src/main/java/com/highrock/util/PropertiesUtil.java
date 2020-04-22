package com.highrock.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 该工具类是为了获取application.yml的属性值，名称必须完全一样，
 */
@Component
@PropertySource("application.yml")
@ConfigurationProperties
public class PropertiesUtil {

    public  static   String stripe_api_key;
    //stripe key

    public void setStripe_api_key(String stripe_api_key) {
        stripe_api_key = stripe_api_key;
    }}

