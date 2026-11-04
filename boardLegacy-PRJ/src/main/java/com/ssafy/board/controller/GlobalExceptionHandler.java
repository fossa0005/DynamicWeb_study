package com.ssafy.board.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//전역예외처리기
//컴파일을 통과한 요청이 실행된 뒤, 처리되지 않은 예외가 Spring MVC 안으로 올라왔을 때 동작
//서비스 계층에서 받은 예외를 받아 적절한 jsp로 보냄
@ControllerAdvice
public class GlobalExceptionHandler {

	//SQLException
	@ExceptionHandler(SQLException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleSqlException(SQLException e, Model model) {
		model.addAttribute("message", "DB접근 중 오류 발생"); //jsp전달 객체
		return "error/error";
	}
}
