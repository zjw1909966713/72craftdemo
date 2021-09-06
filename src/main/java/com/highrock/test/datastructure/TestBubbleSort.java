package com.highrock.test.datastructure;

/**
 * @ClassName: TestBubbleSort
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/23 16:39
 * @Version: 1.0
 */
public class TestBubbleSort {

    public static void main(String[] args) {

        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};

        for (int i = 0; i < arr.length; i++) {
            
        }
        
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }

    }
}



