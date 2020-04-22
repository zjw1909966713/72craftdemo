package com.highrock.util;

import lombok.Data;

/**
 * @author 张进文
 * @ClassName ResResult
 * @Description TODO
 * @Date 2019/10/25 16:43
 * @Version 1.0
 */
@Data
public class ResResult {
    private Integer code;
    private String msg;
    private Object data;

    public static ResResult success(){
        ResResult ret=new ResResult();
        ret.setCode(200);
        ret.setMsg("success");
        return ret;
    }

    public static ResResult success(Object data){
        ResResult ret=new ResResult();
        ret.setCode(200);
        ret.setMsg("success");
        ret.setData(data);
        return ret;
    }
}
