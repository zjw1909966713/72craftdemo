package com.highrock.test.java8.chap4;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @ClassName: Chap4
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 15:34
 * @Version: 1.0
 */
public class Chap4 {
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

        List<Dish> lowCaloricDisher = new ArrayList<>();
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCaloricDisher.add(d);
            }

        }

        Collections.sort(lowCaloricDisher, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });


        List<String> lowCaloricsDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDisher) {
            lowCaloricsDishesName.add(d.getName());
            System.out.println(d.getName());
        }


        long start=System.currentTimeMillis();
        List<String> strings = menu.stream().filter(dish -> dish.getCalories() < 400).sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
        long end=System.currentTimeMillis();
        System.out.println(strings+","+(end-start));

        long start1=System.currentTimeMillis();
        List<String> strings2 = menu.parallelStream().filter(dish -> dish.getCalories() < 400).sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
        long end1=System.currentTimeMillis();
        System.out.println(strings2+","+(end1-start1));


        long start2=System.currentTimeMillis();
        List<String> names = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());
        long end2=System.currentTimeMillis();
        System.out.println(names+","+(end2-start2));

        long start3=System.currentTimeMillis();
        List<String> names1 = menu.parallelStream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).limit(3).collect(Collectors.toList());
        long end3=System.currentTimeMillis();
        System.out.println(names1+","+(end3-start3));

    }
}
