package com.web.myapp.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/**   
 * Function: freemarker静态页面生成工具
 * @author jiangyf   
 * @since 2016年9月9日 下午4:19:54 
 * @version V1.0   
 */
public class FreeMarkerUtil {
	/**
	 * 生成HTML静态页面
	 * @param fmc 
	 * @param templateName 模板的名称
	 * @param request
	 * @param map 生成模板需要的数据
	 * @param filePath 相对于web容器的路径
	 * @param fileName 要生成的文件的名称，带扩展名
	 */
	public static void createHtml(FreeMarkerConfig fmc, String templateName,
			HttpServletRequest request, Map<?, ?> map, String filePath,
			String fileName) {
		Writer out = null;
		try {
			Template template = fmc.getConfiguration().getTemplate(templateName);
			String htmlPath = request.getSession().getServletContext()
					.getRealPath(filePath)+ "/" + fileName;
			File htmlFile = new File(htmlPath);
			if (!htmlFile.getParentFile().exists()) {
				htmlFile.getParentFile().mkdirs();
			}
			if (!htmlFile.exists()) {
				htmlFile.createNewFile();
			}
			out = new OutputStreamWriter(new FileOutputStream(htmlPath),"UTF-8");
			template.process(map, out);
			out.flush();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				out = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 判断文件是否已存在
	 * @param request
	 * @param filePath  文件存放的路径
	 * @param fileName  文件的名称，需要扩展名
	 */
	public static boolean isHtmlFileExist(HttpServletRequest request, 
			String filePath, String fileName) {
		String htmlPath = request.getSession().getServletContext()
				.getRealPath(filePath) + "/" + fileName;
		File htmlFile = new File(htmlPath);
		if(htmlFile.exists()){
			return true;
		}else{
			return false;
		}
	}
}
