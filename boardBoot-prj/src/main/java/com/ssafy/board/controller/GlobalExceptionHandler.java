package com.ssafy.board.controller;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//전역예외처리기
//컴파일을 통과한 요청이 실행된 뒤, 처리되지 않은 예외가 Spring MVC 안으로 올라왔을 때 동작
//서비스 계층에서 예외를 받아 적절한 jsp로 보냄

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalStateException.class)
	public String handleIllegalStateException(Model model) {
		model.addAttribute("message", "예기치 못한 상태");
		return "error/error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Model model) {
		model.addAttribute("message", "알 수 없는 오류");
		return "error/error";
	}
}
