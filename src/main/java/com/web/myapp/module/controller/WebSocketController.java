package com.web.myapp.module.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.myapp.module.entity.Message;
import com.web.myapp.module.service.MessageService;
import com.web.myapp.util.JsonUtil;

/**   
 * WebSocket实时通讯服务
 * @author jiangyf   
 * @since 2016年9月9日 下午4:59:35 
 * @version V1.0   
 */
@Controller
@RequestMapping("/ws")
public class WebSocketController {
	@Resource
	private MessageService messageService;
	
	@RequestMapping(value="/chat", method = RequestMethod.GET)
	public ModelAndView chat(){
		ModelAndView model = new ModelAndView();
		model.setViewName("jsp/chatroom");
		return model;
	}
	
	/**
     * 加载聊天记录
     */
    @RequestMapping("/loadMessage")
    public void loadMessage(HttpServletResponse response){
        JSONObject jsonObject = new JSONObject() ;
        try {
            JSONObject obj = new JSONObject() ;
            List<Message> list = this.messageService.getMessagelList(1, 10);
            obj.put("contents",list) ;
            jsonObject = JsonUtil.parseJson("0","操作成功",obj);
        }catch (Exception e){
            e.printStackTrace();
            JsonUtil.parseJson("1","操作异常","");
        }
        JsonUtil.responseBuildJson(response,jsonObject);
    }

}
