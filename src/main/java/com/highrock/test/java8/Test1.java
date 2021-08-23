package com.highrock.test.java8;

import lombok.Data;

import java.io.File;
import java.io.FileFilter;

/**
 * @ClassName: Test1
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/18 12:15
 * @Version: 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        File[] hiddenFiles= new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        System.out.println(hiddenFiles.length);
        for (File file:hiddenFiles){
            System.out.println(file.getName());
        }

        File[] files = new File(".").listFiles(File::isHidden);

        System.out.println(files.length);
        for (File file:files){
            System.out.println(file.getName());
        }


    }

}


@Data
class Apple{
    private int weight;
    private String color;

}