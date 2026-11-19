package com.ssafy.board.controller;

import java.sql.SQLException;

import org.springframework.boot.web.server.servlet.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.board.model.Member;
import com.ssafy.board.service.BoardService;
import com.ssafy.board.service.BoardServiceImpl;

import jakarta.servlet.http.HttpSession;

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
	
	@PostMapping("/write")
	public String write( @RequestParam("title") String title, 
						@RequestParam("content") String content,
						HttpSession session) throws SQLException {
		Member loginMember = (Member)session.getAttribute("loginMember");
		service.writeBoard(title, content, loginMember.getMemberId());
		return "redirect:/list";
	}
	
	
}
