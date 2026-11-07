package com.ssafy.board.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.board.model.LoginResult;
import com.ssafy.board.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	private final LoginService service;
	
	
	@Autowired
	public LoginController(LoginService service) {
		this.service = service;
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}
	
	@GetMapping("/registerForm")
	public String registerForm() {
		return "login/registerForm";
	}
	
	//스프링에서는 request.getParameter 대신
	//컨트롤러 메서드의 매개인자로 패러미터 받을 수 있음
	@PostMapping("/login") 
	public String login(@RequestParam("id") String id, 
						@RequestParam("pw") String pw, 
						HttpSession session,
						Model model) throws SQLException {
		LoginResult result = service.login(id, pw);
		
		if("login_success".equals(result.getStatus())) {
			session.setAttribute("loginMember", result.getMember());
			return "redirect:/board";
			//브라우저가 메인컨트롤러로 /board 새 요청
		}
		
		
		if("id_not_found".equals(result.getStatus())) {
			model.addAttribute("errorMsg", "존재하지 않는 id입니다");
			return "login/loginForm";
			//뷰 렌더링
			//loginForm.jsp
		}
			
		if("wrong_password".equals(result.getStatus())) {
			model.addAttribute("errorMsg", "비밀번호가 틀렸습니다");
			return "login/loginForm";
			//뷰 렌더링
			//loginForm.jsp
		}
		
		else throw new IllegalStateException();
	}

}
