package com.highrock.demo;

/**
 * @author 张进文
 * @ClassName Test1
 * @Description TODO
 * @Date 2019/11/29 10:09
 * @Version 1.0
 */
public class Test1 {

    public static String converToBin(int n){



        String result="";

        if(n==0||n==1){
            result=String.valueOf(n);
        }

        for (int i = n; i >0 ;i/=2) {
            result=i%2+result;
            
        }



        return result;

    }


    public static void converByValue(int a){
        a++;
    }

    public static void converByRef(StringBuffer aa){
      aa.append("mmmmm");
    }


    public static void main(String[] args) {


        long start = System.currentTimeMillis();

        long timeMillis = System.currentTimeMillis();

        System.out.println(converToBin(0));

        long end=System.currentTimeMillis();

        long cha=end-start;
        System.out.println(start);
        System.out.println(end);


        System.out.println("总耗时:"+cha);

        int a=12;
        converByValue(a);
        System.out.println(a);
       StringBuffer aa=new StringBuffer("dddd");
        converByRef(aa);
        System.out.println(aa);

    }
}
