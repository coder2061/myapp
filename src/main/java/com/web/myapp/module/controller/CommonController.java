package com.web.myapp.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.web.myapp.core.config.CommonConfig;
import com.web.myapp.module.model.Area;

/**   
 * 测试通用
 * @author jiangyf   
 * @since 2016年9月9日 下午5:02:33 
 * @version V1.0   
 */
@Controller
public class CommonController {
	
	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("name", name);
		return model;

	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView model = new ModelAndView();
		model.setViewName("jsp/commonTest");
		return model;
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public ModelAndView check() {
		ModelAndView model = new ModelAndView();
		model.setViewName("jsp/checkCard");
		return model;
	}
	
	@RequestMapping(value="/testJAXB", method = RequestMethod.GET)
	@ResponseBody
	public Area testJAXB() {
		Area area = new Area("China", "beijing", "chaoyang", "wangjing", "100000");
		return area;
	}
	
	@RequestMapping(value="/testProp", method = RequestMethod.GET)
	public void testProp(){
		System.out.println(CommonConfig.getValue("worker_id"));
		System.out.println(CommonConfig.getValue("driver", "jdbc.properties"));
		System.out.println(CommonConfig.getValue("datacenter_id"));
	}

}
