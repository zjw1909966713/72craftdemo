package com.highrock.test.java8.chap2;

/**
 * @ClassName: MeanOfThis
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 14:38
 * @Version: 1.0
 */
public class MeanOfThis {
    public  final int value=4;
    public void doIt(){
        int value=6;
        Runnable runnable = new Runnable() {
            public final int value = 5;

            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        runnable.run();
    }

    public static void main(String[] args) {
        MeanOfThis m=new MeanOfThis();
        m.doIt();
    }
}
