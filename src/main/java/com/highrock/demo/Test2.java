package com.highrock.demo;

/**
 * @author 张进文
 * @ClassName Test2
 * @Description TODO
 * @Date 2019/11/29 16:09
 * @Version 1.0
 */
public class Test2 {

    public static long fbnq(int n) {
        if (n <= 2) {
            return n;
        }
        return fbnq(n - 1) + fbnq(n - 2);
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fbnq(45));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Runtime.getRuntime().availableProcessors());


    }
}
