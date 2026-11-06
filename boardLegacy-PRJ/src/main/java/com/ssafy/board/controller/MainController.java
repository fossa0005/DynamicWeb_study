package com.ssafy.board.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ssafy.board.model.Board;
import com.ssafy.board.service.BoardService;
import com.ssafy.board.service.BoardServiceImpl;

@Controller //알아서 싱글톤
public class MainController {
	private final BoardService service;
	
	//DI
	public MainController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String main() {
	    return "main"; //main.jsp로 감
	}
	
	@GetMapping("/board")
	public String board(Model model) throws SQLException {
		List<Board> boards = service.getBoardList();
		model.addAttribute("boards", boards); //jsp 전달 객체
		return "list"; //list.jsp로 감
	}
	
	@GetMapping("/board/detail/{no}")
	public String detail(@PathVariable("no") int no, Model model) throws SQLException {
		model.addAttribute("board", service.getBoardDetail(no));
		return "detail";
	}
}
