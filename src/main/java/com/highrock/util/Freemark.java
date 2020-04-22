/**  
 * @date 2016年11月4日 下午5:29:02
 */
package com.highrock.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * ClassName: Freemarker 
 * @Description: 
 * @author 张进文
 * @date 2016年11月4日 下午5:29:02
 */
public class Freemark {
	
	/**
	 * 更具相应的freeMarker模板成相应的word
	 * @Description: 
	 * @author 张进文
	 * @date 2016年11月4日 下午9:42:55  
	 *@param templateName freemarker模板名称 例如“qrd2.ftl”
	 *@param filePath 成文件的路径
	 *@param fileName 生成文件的名称
	 *@param map
	 */
	public static void createWord(String templateName,String filePath,String fileName,Map<String,Object> map){
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(Freemark.class,"/");	//创建freemarker配置
		Template t = null;
		try {
			t = configuration.getTemplate(templateName);
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
		File outFilePath=new File(filePath);
		if(!outFilePath.exists()){
			outFilePath.mkdirs();
		}
		
		File outFile = new File(filePath+fileName);
		if(!outFile.exists()){
			try {
				outFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			t.process(map, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
