package com.highrock.test;

/**
 * @author 张进文
 * @ClassName Main
 * @Description TODO
 * @Date 2020/1/13 16:25
 * @Version 1.0
 */
public class Main {

    static long fib(long n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        long start = System.nanoTime()/1000000;
        System.out.println(fib(49));
        long end = System.nanoTime()/1000000;
        System.out.println(end - start);
    }
}
