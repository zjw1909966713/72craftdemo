package com.highrock.test.java8.chap2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Test
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 13:56
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {

        List<Apple> inventory= Arrays.asList(new Apple(80,"green"),new Apple(155,"green"),new Apple(120,"red"));
        List<Apple> greenApples=filterApplesByColor(inventory,"green");
        List<Apple> redApples=filterApplesByColor(inventory,"red");

        List<Apple> redAndHeavyApples=filterApples(inventory,new AppleRedAndHeavyPredicate());


        filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        List<Apple> result=filterApples(inventory,(Apple apple)->"red".equals(apple.getColor()));


        List<Apple> redApples1=filter(inventory,(Apple apple)->"red".equals(apple.getColor()));

        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> evenNumbers=filter(numbers,(Integer i) ->i%2==0);




    }


    public static List<Apple> filterGreenApples(List<Apple> inventory){


        List<Apple> result=new ArrayList<Apple>();

        for (Apple apple:inventory) {
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;

    }


    public static  List<Apple> filterApplesByColor(List<Apple> inventory,String color){
        List<Apple> result=new ArrayList<Apple>();

        for (Apple apple:inventory) {
            if(color.equals(apple.getColor())){
                result.add(apple);
            }
        }

        return result;

    }

    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        List<Apple> result=new ArrayList<>();
        for (Apple apple:inventory) {
            if (p.test(apple)){
                result.add(apple);
            }

        }
        return result;
    }

    public static <T> List<T> filter(List<T> list,Predicate<T> p){
        List<T> result=new ArrayList<>();
        for (T e:list){
            if (p.test(e)){
                result.add(e);
            }
        }

        return result;
    }






}


