package com.highrock.test.java8.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: Chap5
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 16:34
 * @Version: 1.0
 */
public class Chap5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i%2==0).distinct().forEach(System.out::println);


        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream().map(integer ->integer*integer).forEach(System.out::println);


        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
//        numbers1.stream().

        List<String> words=Arrays.asList("Hello","World");


        List<String> collect = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);




    }
}
