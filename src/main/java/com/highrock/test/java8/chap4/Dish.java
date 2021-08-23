package com.highrock.test.java8.chap4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Dish
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 15:31
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private String name;
    private boolean vegetarian;
    private Integer calories;
    private Type type;

    public enum Type{
        MEAT,FISH,OTHER
    }

}
