package com.highrock.test.aliyun;



import com.alibaba.fastjson.JSONObject;
import com.highrock.test.ocr_general.FileUtil;
import com.highrock.test.ocr_general.HttpUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Test
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/08/24 16:02
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) throws Exception {
        String host = "https://ocrapi-advanced.taobao.com";
        String path = "/ocrservice/advanced";
        String method = "POST";
        String appcode = "40e81cd7f803454caae6354d7bf02737";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        byte[] imageByteArray = FileUtil.read("e:/f2.jpg");
        String imageBase64 = new String(Base64.encodeBase64(imageByteArray), "UTF-8");
        String bodys = "{\"img\":\"\",\"url\":\"\",\"prob\":false,\"charInfo\":false,\"rotate\":false,\"table\":false}";

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("img",imageBase64);
        jsonObject.put("prob",false);
        jsonObject.put("charInfo",false);
        jsonObject.put("rotate",false);
        jsonObject.put("table",false);
        jsonObject.put("sortPage",false);



        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            String s = HttpUtil.doPost1(host + path, headers, jsonObject.toJSONString());
//            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response.toString());
            //获取response的body
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
