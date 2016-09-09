package com.web.myapp.module.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.web.myapp.util.FreeMarkerUtil;


/**   
 * Function: FreeMark模板引擎
 * @author jiangyf   
 * @since 2016年9月9日 下午4:55:54 
 * @version V1.0   
 */
@Controller
@RequestMapping("/ftl")
public class FreeMarkerController {
	@Autowired
	private FreeMarkerConfig freemarkerConfig;
	private static Log logger = LogFactory.getLog(FreeMarkerController.class);
	
	@RequestMapping("/testftl")
    public String testftl(Model model) {
       model.addAttribute("name","jade");
        return "testftl.ftl";
    }
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request,HttpServletResponse response, ModelMap mv){
		String filePath = "ftl";
		String fileName ="testftl.html";
		Boolean flag =FreeMarkerUtil.isHtmlFileExist(request, filePath, fileName);
		//如何静态文件不存在，重新生成
		if(!flag){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", "jade");
			mv.addAllAttributes(map);
			//根据模板生成静态页面
	        FreeMarkerUtil.createHtml(freemarkerConfig, "template.ftl", request, map, filePath, fileName);
		}
		//始终返回生成的HTML页面
		return filePath+"/"+fileName;
	}
	
	@RequestMapping(value = "/test1")
    public String test1(HttpServletRequest request, ModelMap map) {
        logger.info("使用JSP视图解析器");
        map.put("name", "hello world");
        return "jspTest.jsp";
    }
    
    @RequestMapping(value = "/test2")
    public String test2(HttpServletRequest request, ModelMap map) {
        logger.info("使用Freemarker视图解析器");
        map.put("name", "hello world");
        return "hello.ftl";
    }
    
    @RequestMapping(value = "/test3")
    public String test3(HttpServletRequest request, ModelMap map) {
        logger.info("使用Velocity视图解析器");
        map.put("name", "hello world");
        return "/html/demo.htm";
    }

}
