package com.web.myapp.module.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.myapp.module.entity.Member;
import com.web.myapp.module.lucene.LuceneIndex;
import com.web.myapp.module.model.User;
import com.web.myapp.module.service.MemberService;
import com.web.myapp.util.GsonUtil;
import com.web.myapp.util.StringUtils;

/** 
 * Function:  
 * @author jiangyf   
 * @since 2016年8月24日 下午3:32:07 
 * @version V1.0   
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private MemberService memberService;
	
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
	
	@RequestMapping(value="/getMember", method = RequestMethod.GET)
	public ModelAndView getMember(){
		String name = this.memberService.getMemberList().get(0).getName();
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("name", name);
		return model;
	}
	
	@RequestMapping("/query")
	public String search(@RequestParam(value = "key", required = false, defaultValue = "") String key,
	                     @RequestParam(value = "page", required = false, defaultValue = "1") String page,
	                     Model model, HttpServletRequest request) throws Exception {
	    LuceneIndex luceneIndex = new LuceneIndex() ;
	    List<Member> memberList = luceneIndex.query(key);
	    model.addAttribute("key", key) ;
	    model.addAttribute("list", memberList) ;
	    model.addAttribute("total", memberList.size()) ;
	    return "memberlist";
	}
	
}
