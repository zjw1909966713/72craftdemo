package com.highrock.test.java8.chap2;

/**
 * @ClassName: AppleHeavyWeightPredicate
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 14:18
 * @Version: 1.0
 */
public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}
