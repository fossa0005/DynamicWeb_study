package com.ssafy.myprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
//	spring.mvc.view.prefix=/WEB-INF/views/index.jsp
//	spring.mvc.view.suffix=.jsp
	// http://localhost:8080/index
	@RequestMapping("/index")
	public void index() {
		System.out.println("index 호출");
	}
}
