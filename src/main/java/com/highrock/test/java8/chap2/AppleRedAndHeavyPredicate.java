package com.highrock.test.java8.chap2;

/**
 * @ClassName: AppleRedAndHeavyPredicate
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 14:24
 * @Version: 1.0
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor())&&apple.getWeight()>150;
    }
}
