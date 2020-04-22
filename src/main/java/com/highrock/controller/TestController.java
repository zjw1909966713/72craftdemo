package com.highrock.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import com.highrock.service.WebSocket;
import com.highrock.util.BaseJsonRst;
import com.highrock.util.QrCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @author 张进文
 * @ClassName TestController
 * @Description TODO
 * @Date 2019/3/13 12:24
 * @Version 1.0
 */
@RestController
@CrossOrigin
public class TestController {


    @Autowired
    private WebSocket webSocket;

    @GetMapping("/testWebSocket")
    public void  testWebSocket(){

        String id= UUID.randomUUID().toString();

        webSocket.sendMessage(id);

    }


    /**
     * 二维码
     * @param request
     * @param response
     */
    @GetMapping("/qrcode")
    public void qrcode(HttpServletRequest request, HttpServletResponse response) {
        StringBuffer url = request.getRequestURL();
        // 域名
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

        // 再加上请求链接
        String requestUrl = tempContextUrl + "/index";
        try {
            OutputStream os = response.getOutputStream();
            QrCodeUtils.encode(requestUrl, "/static/images/logo.png", os, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/qrcode1")
    public BaseJsonRst qrcode1(HttpServletRequest request, HttpServletResponse response) {
        BufferedImage generate = QrCodeUtil.generate("https://map.baidu.com/@13068995.705361597,4695400.415140215,13.9z", 300, 300);

        //io流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //写入流中
        try {
            ImageIO.write(generate, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //转换成字节
        byte[] bytes = baos.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        //转换成base64串
        String png_base64 =  encoder.encodeBuffer(bytes).trim();

        //删除 \r\n
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");
        StringBuffer sb=new StringBuffer();
        sb.append("data:image/png;base64," ).append(png_base64);
        return BaseJsonRst.success(sb.toString());


    }


}
