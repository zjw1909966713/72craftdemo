package com.highrock.demo;

import java.util.Random;

/**
 * @author 张进文
 * @ClassName Test3
 * @Description TODO
 * @Date 2019/12/2 9:57
 * @Version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        Random rd = new Random();
        int r = rd.nextInt(3) + 10;
        System.out.println(r);
        long t1 = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i <= 40000 + r; i++) {
            for (int j = 0; j <= 40000; j++) {
                sum = sum + i * j;
            }

        }
        System.out.println(sum);
        long t2 = System.currentTimeMillis();
        System.out.println("间隔时间:" + (t2-t1) + "毫秒");



    }
}
