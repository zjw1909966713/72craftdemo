package com.highrock.test.java8.chap5;

import com.highrock.test.java8.chap4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName: Test
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/19 08:00
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef",false, 700, Dish.Type.MEAT),
                new Dish("chicken",false, 400, Dish.Type.MEAT),
                new Dish("fresh fries",true, 530, Dish.Type.OTHER),
                new Dish("rice",true, 350, Dish.Type.OTHER),
                new Dish("season fruit",true, 120, Dish.Type.OTHER),
                new Dish("pizza",true, 550, Dish.Type.OTHER),
                new Dish("prawns",true, 300, Dish.Type.FISH),
                new Dish("salmon",true, 450, Dish.Type.FISH)


        );

        Optional<Dish> any = menu.stream().filter(Dish::isVegetarian).findFirst();
        System.out.println(any.isPresent()+","+any.get().getName());

        List<Integer>  numbers=Arrays.asList(12,5,3,6,9,13,56,85);
        Integer reduce = numbers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);


        String menuNames = menu.stream().map(Dish::getName).collect(Collectors.joining(","));

        System.out.println(menuNames);


    }
}
