package com.highrock.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.highrock.util.BaseJsonRst;
import com.highrock.util.DownloadSupport;
import com.highrock.util.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 张进文
 * @ClassName ImageController
 * @Description TODO
 * @Date 2018/12/27 12:18
 * @Version 1.0
 */

@RestController
@Api(value="ImageController用户相关的API")
@Slf4j
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    @ApiOperation(value = "上传并截取图片")
    @PostMapping(value = "/cut")
    public BaseJsonRst cutImage(MultipartFile avatar_file,String avatar_data){

        JSONObject data=JSONObject.parseObject(avatar_data);
        String  compressImgPath=null;
        try {

            compressImgPath= ImageUtil.cutImage(avatar_file,data.getInteger("x"),data.getInteger("y"),data.getInteger("width"),data.getInteger("height"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    log.info(compressImgPath);

        return null;
    }


    @RequestMapping("/download")
    public void downLoad(String path, HttpServletRequest request, HttpServletResponse response){
        //获得原文件名
        String filename=path.substring(path.lastIndexOf("/")+1);
        DownloadSupport.download(request,response,path,filename);
    }

}
