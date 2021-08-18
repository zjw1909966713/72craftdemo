package com.highrock.test;

import java.util.Arrays;

/**
 * @ClassName: TestSort
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/07/27 11:16
 * @Version: 1.0
 */
public class TestSort {
    public static void main(String[] args) {

        int[] arr1=new int[]{5,7,4,3};
//        bubbleSort(arr1);
//        System.out.println(Arrays.toString(arr1));

        System.out.println(Arrays.toString(arr1));
        selectSort(arr1);
        System.out.println(Arrays.toString(arr1));



    }



    /**
    * @Method: bubbleSort
    * @Author: zjw
    * @Description: 冒泡排序
    * @Date: 2021/07/27 11:24
    * @Param arr
    * @Return: void
    * @Version:    1.0
    **/
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }
        }
    }


    /**
    * @Method: selectSort
    * @Author: zjw
    * @Description: 选择排序
    * @Date: 2021/07/27 11:50
    * @Param arr
    * @Return: void
    * @Version:    1.0
    **/
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[min]>arr[j]){
                    min=j;
                }
            }

            if (i!=min){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }



        }

    }




}
