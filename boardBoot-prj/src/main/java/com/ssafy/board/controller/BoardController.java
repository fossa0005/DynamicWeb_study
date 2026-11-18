package com.ssafy.board.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.board.service.BoardService;
import com.ssafy.board.service.BoardServiceImpl;

@Controller
public class BoardController {
	private final BoardService service;
	
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public String list(Model model) throws SQLException {
		model.addAttribute("boards", service.getBoardList());
		return "list";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	
}
