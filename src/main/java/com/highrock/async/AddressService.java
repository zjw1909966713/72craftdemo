package com.highrock.async;

/**
 * @ClassName: AddressService
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/09/03 11:09
 * @Version: 1.0
 */
public class AddressService {

    public String getAddress()  {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "tianjin";
    }

}
