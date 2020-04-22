package com.highrock.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lw
 */
public class DownloadSupport {

	/**
	 * 
	 * @Description:
	 * @author 张进文
	 * @date 2016年7月11日 上午9:42:08
	 * @param request
	 * @param response
	 * @param path
	 * @param filename
	 */
	public static void download(HttpServletRequest request,
			HttpServletResponse response, String path, String filename) {

//		File file = new File(request.getSession().getServletContext()
//				.getRealPath(path));
		File file = new File(path);
		System.out.println("==============gg========================"
				+ request.getSession().getServletContext().getRealPath(path));
		response.reset();
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Length", file.length() + "");

		try {
			// 设置头部信息
			response.setHeader("Content-Disposition", "attachment; filename="
					+ new String(filename.getBytes(), "ISO8859-1"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		System.out
				.println("===================================================="
						+ filename);

		PrintWriter out = null;
		FileInputStream in = null;
		try {
			// System.out.println(request.getSession().getServletContext().getRealPath(myFile.getLocation()));

//			in = new FileInputStream(request.getSession().getServletContext()
//					.getRealPath("/" + path));
			in = new FileInputStream( path);
			out = response.getWriter();
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * * 复制单个文件
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf.txt
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 * @Description:
	 * @author 张进文
	 * @date 2016年8月18日 下午2:04:26
	 * @param oldPath 文件老的路径
	 * @param newPath 新建新路径
	 * @param  folderPath 文件夹路径
	 */
	public static void copyFile(String oldPath, String newPath,String folderPath) {
		System.out.println("================拷贝文件开始=======================");
		System.out.println("oldPath=========================================="+oldPath);
		System.out.println("newPath=========================================="+newPath);
		
		
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				
				File f=new File(folderPath);
				if(!f.exists()){
					f.mkdirs();
				}
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1024*1024];//1G
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
				System.out.println("成功");
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}

	}

	/**
	 * 复制整个文件夹内容
	 * 
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf/ff
	 * @return boolean
	 */
	public static void copyFolder(String oldPath, String newPath) {

		try {
			(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();

		}

	}
	
	public static void main(String[] args ){
		String ss="d:\\dd\\ss";
		String s1=ss.replaceAll("\\\\", "/");
		System.out.println(s1);
		
		copyFile("E:/shengke/.metadata/.me_tcat7/webapps/SKKJ/image/zlywjmb/100001.doc", "D:/s1.doc","D:");
		
		
	}
}
