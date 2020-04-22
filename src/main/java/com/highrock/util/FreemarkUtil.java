/**  
 * @date 2016年11月4日 下午5:29:02
 */
package com.highrock.util;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

/**
 * ClassName: Freemarker 
 * @Description: 
 * @author 张进文
 * @date 2016年11月4日 下午5:29:02
 */
public class FreemarkUtil {
	
	/**
	 * 更具相应的freeMarker模板成相应的word
	 * @Description: 
	 * @author 张进文
	 * @date 2016年11月4日 下午9:42:55  
	 *@param templateName freemarker模板名称 例如“qrd2.ftl”
	 *@param map
	 */
	public static String createHtml(String templateName,Map<String,Object> map) {
		String html="";
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDefaultEncoding("utf-8");
		//创建freemarker配置
		configuration.setClassForTemplateLoading(FreemarkUtil.class, "/");
		Template t = null;
		try {
			t = configuration.getTemplate(templateName);
			StringWriter out=new StringWriter();
			t.process(map,out);
			System.out.println(out.toString());
			html=out.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}
	

}
