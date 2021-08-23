package com.highrock.test.java8.chap3;

import com.highrock.test.java8.chap2.Apple;
import com.highrock.test.java8.chap2.Predicate;

import java.util.Comparator;

/**
 * @ClassName: Test3
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 15:01
 * @Version: 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        Comparator<Apple> byWeight=new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        };
        Comparator<Apple> byWeight2=(Apple a1,Apple a2)->a1.getWeight()-a2.getWeight();

        Predicate<String> nonEmptyString=(String s)->!s.isEmpty();
    }
}
