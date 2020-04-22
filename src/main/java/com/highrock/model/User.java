package com.highrock.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author 张进文
 * @ClassName User
 * @Description TODO
 * @Date 2018/11/28 10:41
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private int age;
    private String password;
    private Date ctm;
    private Date utm;

}
