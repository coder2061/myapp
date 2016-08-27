package com.web.myapp.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.myapp.module.model.Area;
import com.web.myapp.module.model.User;
import com.web.myapp.util.GsonUtil;
import com.web.myapp.util.StringUtils;

/** 
 * Function:  
 * @author jiangyf   
 * @since 2016年8月24日 下午3:32:07 
 * @version V1.0   
 */
@Controller
public class UserController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "index";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("msg", name);
		return model;

	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView model = new ModelAndView();
		model.setViewName("jsp/commonTest");
		return model;
	}
	
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public void getUserInfo(HttpServletRequest request) {
		try {
			String params = StringUtils.readToString(request.getInputStream());
			User user = (User) GsonUtil.json2Bean(params, User.class);
			System.out.println(GsonUtil.bean2Json(user));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/testJAXB", method = RequestMethod.GET)
	@ResponseBody
	public Area testJAXB() {
		Area area = new Area("China", "beijing", "chaoyang", "wangjing", "100000");
		return area;
	}

}
