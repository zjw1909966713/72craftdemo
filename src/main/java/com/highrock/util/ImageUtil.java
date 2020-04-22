package com.highrock.util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * @author 张进文
 * @ClassName ImageUtil
 * @Description TODO
 * @Date 2018/12/27 13:51
 * @Version 1.0
 */
public class ImageUtil {

    /**
     * @param x坐标
     * @param y坐标
     * @param width宽度
     * @param height高度
     * @描述 —— 裁剪图片
     */
    public static String cutImage(MultipartFile file, int x, int y, int width, int height) throws IOException {
        //得到上传时的文件名
        String filename = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //获取uuid作为文件名
        String name = UUID.randomUUID().toString();
        filename = name + suffixName;
        //存储地址
        String filePath = "D:/images/";
        //图片路径
        String path_img = filePath + filename;
        File dest = new File(path_img);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }



        FileInputStream is = null;
        ImageInputStream iis = null;
        try {
            // 如果源图片不存在
            if (!new File(path_img).exists()) {
                return "失败";
            }
            // 读取图片文件
            is = new FileInputStream(path_img);
            // 获取文件格式
            String ext = path_img.substring(path_img.lastIndexOf(".") + 1);
            // ImageReader解码指定格式
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(ext);
            ImageReader reader = it.next();
            // 获取图片流
            iis = ImageIO.createImageInputStream(is);
            // 输入源中的图像将只按顺序读取
            reader.setInput(iis, true);
            // 描述如何对流进行解码
            ImageReadParam param = reader.getDefaultReadParam();
            // 图片裁剪区域
            Rectangle rect = new Rectangle(x, y, width, height);
            // 提供一个 BufferedImage，将其用作解码像素数据的目标
            param.setSourceRegion(rect);
            // 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象
            BufferedImage bi = reader.read(0, param);
            // 保存新图片

            String name1 = UUID.randomUUID().toString();
            String newFileName = name1 + suffixName;
            String new_path_img = filePath + newFileName;

            File tempOutFile = new File(new_path_img);
            if (!tempOutFile.exists()) {
                tempOutFile.mkdirs();
            }
            ImageIO.write(bi, ext, tempOutFile);

            //为压缩后图片创建路径
            String compressImgPath = UUID.randomUUID().toString() + suffixName;
            String compress_img_path = filePath + compressImgPath;

            //等比压缩图片，使用Java
//            boolean flag = compressImg(new_path_img, compress_img_path,100,100,true);

            /*
            * 压缩图片，使用Thumbnails工具
            * 先判断图片大小，如果小于50 kb（51200字节）不进行压缩
            * file.length()方法最大只能获取2g的文件大小，但是前台传给后台图片最大为10M，所以此处不必担心
            */
            if(tempOutFile.length() < 51200){
                compressImgPath = newFileName;
                compress_img_path = new_path_img;
                File noCompressFile = new File(compress_img_path);
                if (!noCompressFile.exists()) {
                    tempOutFile.mkdirs();
                }
            }
            else {
                //首先判断图片类型,如果是png格式图片，就修改图片类型成jpg格式（图片尺寸不变）。
                if (suffixName.equals(".png")) {
                    Thumbnails.of(new_path_img)
                            .scale(1f)
                            .outputFormat("jpg")
                            .toFile(filePath + name1);
                }
                Thumbnails.of(new_path_img)
                        .scale(1f)//图片长宽大小
                        .outputQuality(0.1f)//图片质量
                        .toFile(compress_img_path);
            }




            return compressImgPath;

        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (iis != null) {
                    iis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "失败";
            }
        }
    }
}
