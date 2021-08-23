package com.highrock.test.java8.chap3;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Test
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 15:20
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        forEach(Arrays.asList(1,2,3,4,5),(Integer i)-> System.out.println(i));
    }


    public static <T> void forEach(List<T> list,Consumer<T> c){
        for (T i:list) {
            c.accept(i);
        }
    }
}
