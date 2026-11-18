package com.ssafy.board.controller;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//전역예외처리기
//컴파일을 통과한 요청이 실행된 뒤, 처리되지 않은 예외가 Spring MVC 안으로 올라왔을 때 동작
//서비스 계층에서 예외를 받아 적절한 jsp로 보냄
//가장 구체적으로 일치하는 처리기로 먼저 감 

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalStateException.class)
	public String handleIllegalStateException(IllegalStateException e, Model model) {
		model.addAttribute("message", e.getMessage());
		return "error/error";
	}
	
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(Model model) {
		model.addAttribute("message", "DB 조회 중 오류 발생");
		return "error/error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		model.addAttribute("message", e.getMessage());
		return "error/error";
	}
}
