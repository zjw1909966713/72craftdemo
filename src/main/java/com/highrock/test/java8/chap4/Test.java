package com.highrock.test.java8.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName: Test
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 16:06
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<String> title= Arrays.asList("Java8","in","Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }
}
