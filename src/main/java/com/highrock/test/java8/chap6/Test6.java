package com.highrock.test.java8.chap6;

import java.util.stream.Stream;

/**
 * @ClassName: Test6
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/19 10:03
 * @Version: 1.0
 */
public class Test6 {
    public static void main(String[] args) {




        long begin1=System.currentTimeMillis();
        long l1 = sequentialSum(900000L);
        long  end1=System.currentTimeMillis();
        System.out.println("结果:"+l1+",时间:"+(end1-begin1));


        long begin2=System.currentTimeMillis();
        long l2 = iterativeSum(900000L);
        long  end2=System.currentTimeMillis();
        System.out.println("结果:"+l2+",时间:"+(end2-begin2));


        long begin3=System.currentTimeMillis();
        long l3 = parallelSum(900000L);
        long  end3=System.currentTimeMillis();
        System.out.println("结果:"+l1+",时间:"+(end3-begin3));




    }


    public static long sequentialSum(long n){
        return Stream.iterate(1L,i->i+1).limit(n).reduce(0L,Long::sum);
    }

    public static long parallelSum(long n){
        return Stream.iterate(1L,i->i+1).limit(n).parallel().reduce(0L,Long::sum);
    }

    public static long iterativeSum(long n){
        long result=0;
        for (long i = 1L; i <=n ; i++) {
            result+=i;

        }
        return  result;
    }
}
