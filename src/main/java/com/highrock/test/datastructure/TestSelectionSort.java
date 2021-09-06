package com.highrock.test.datastructure;

/**
 * @ClassName: SelectionSort
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/23 15:26
 * @Version: 1.0
 */
public class TestSelectionSort {
    public static void main(String[] args) {

        int[] arr = {5, 3, 6, 8, 1, 7, 9, 4, 2};

        for (int i = 0; i < arr.length; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
            }
            System.out.println("minPos:" + minPos);
            swap(arr, i, minPos);

            System.out.println("经过第" + i + "次循环之后，数组的内容：");
            print(arr);


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
