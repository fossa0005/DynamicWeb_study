package com.ssafy.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String main() {
	    return "main"; //main.jsp로 감
	}
	
	@GetMapping("/board")
	public String board() {
		return "board"; //board.jsp로 감
	}
}
