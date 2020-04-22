package com.highrock.service.impl;

import com.highrock.service.DemoWebService;

import javax.jws.WebService;
import java.util.Date;

/**
 * @author 张进文
 * @ClassName DemoWebServiceImpl
 * @Description TODO
 * @Date 2019/2/27 16:28
 * @Version 1.0
 */

@WebService(
        serviceName = "DemoWebService",//与接口中指定的name一致
        targetNamespace = "http://service.highrock.com",//与接口中的命名空间一致，一般是接口的包名倒叙
        endpointInterface = "com.highrock.service.DemoWebService"
)
public class DemoWebServiceImpl implements DemoWebService {
    @Override
    public String sayHello(String User) {
        return User+"现在时间："+new Date();
    }
}
