package com.highrock.util;

import lombok.Data;

import java.io.Serializable;

/**
 *此类用于返回结构
 * @author zhangjinwen
 * @create 2017-11-01 11:05
 * @desc
 **/
@Data
public class BaseJsonRst implements Serializable {

    private static final long serialVersionUID = -5275721057201583544L;
    /**成功或失败的标志*/
    private boolean success;


    /**成功或失败的信息*/
    private String message;


    /**结果集*/
    private Object result;



    public static BaseJsonRst success(){
        BaseJsonRst ret=new BaseJsonRst();
        ret.setSuccess(true);
        ret.setMessage("success");
        return ret;
    }
    public static BaseJsonRst success(Object o){
        BaseJsonRst ret=new BaseJsonRst();
        ret.setSuccess(true);
        ret.setMessage("success");
        ret.setResult(o);
        return ret;
    }
    public static BaseJsonRst success(String message,Object o){
        BaseJsonRst ret=new BaseJsonRst();
        ret.setSuccess(true);
        ret.setMessage(message);
        ret.setResult(o);
        return ret;
    }
    public static BaseJsonRst error(String message){
        BaseJsonRst ret=new BaseJsonRst();
        ret.setSuccess(false);
        ret.setMessage(message);
        return ret;
    }
    public static BaseJsonRst error(String message,Object o){
        BaseJsonRst ret=new BaseJsonRst();
        ret.setSuccess(false);
        ret.setMessage(message);
        ret.setResult(o);
        return ret;
    }

}
