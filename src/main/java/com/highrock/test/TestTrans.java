package com.highrock.test;

import java.util.Scanner;

/**
 * @ClassName: TestTrans
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/07/26 13:57
 * @Version: 1.0
 */
public class TestTrans {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String talkStr="";


        for (;;){
            talkStr=scanner.next();
            talkStr=talkStr.replace("吗","");
            talkStr=talkStr.replace("?","!");
            System.out.println(talkStr);
        }
    }
}
