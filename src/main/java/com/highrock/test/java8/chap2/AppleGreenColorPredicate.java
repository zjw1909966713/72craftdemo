package com.highrock.test.java8.chap2;

/**
 * @ClassName: AppleGreenColorPredicate
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 14:19
 * @Version: 1.0
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
