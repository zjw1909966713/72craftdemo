package com.highrock.test.java8.chap2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Apple
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 15:03
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple{
    private int weight;
    private String color;

}
