package com.web.myapp.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**   
 * Function: WebSocket实时通讯服务
 * @author jiangyf   
 * @since 2016年9月9日 下午4:59:35 
 * @version V1.0   
 */
@Controller
@RequestMapping("/ws")
public class WebSocketController {
	
	@RequestMapping(value="/chat", method = RequestMethod.GET)
	public ModelAndView chat(){
		ModelAndView model = new ModelAndView();
		model.setViewName("jsp/chatroom");
		return model;
	}

}
