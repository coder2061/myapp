package com.web.myapp.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestCtrl {
	
	@RequestMapping("/test")
	public String toTest(){
		
		return "commonTest";
	}
}
