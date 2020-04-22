package com.highrock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author 张进文
 * @ClassName UserDTO
 * @Description TODO
 * @Date 2018/12/25 11:59
 * @Version 1.0
 */
@Data
@ApiModel(value = "用户注册对象",description = "注册参数")
public class UserDTO implements Serializable{

    @ApiModelProperty(value = "用户名",required = true,example = "zhangsan" ,dataType ="string" )
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "年龄",example ="2",dataType = "Integer",notes = "年龄，这个字段不是必须的")
    private Integer age;

    @ApiModelProperty(value = "用户密码",required = true,example = "123456" ,dataType ="string" )
    @NotBlank(message = "用户密码不能为空")
    private  String password;

}
