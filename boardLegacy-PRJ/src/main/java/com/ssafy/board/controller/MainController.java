package com.ssafy.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.board.model.Board;
import com.ssafy.board.service.BoardService;
import com.ssafy.board.service.BoardServiceImpl;

@Controller //기본 싱글톤
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
	public String board(Model model) {
		List<Board> boards = service.getBoardList();
		model.addAttribute("boards", boards);
		return "board"; //board.jsp로 감
	}
}
