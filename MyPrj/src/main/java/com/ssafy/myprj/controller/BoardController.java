package com.ssafy.myprj.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.myprj.model.dto.Board;
import com.ssafy.myprj.model.service.BoardService;

@Controller
public class BoardController {
	
	private final BoardService boardService;
	
//	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@GetMapping("/board/list")
	public String list(Model model) throws SQLException {
		/*
		DAO
		결과물
		결과물 공유
		페이지 이동
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		rd.forward(request, response)
		*/
		List<Board> list = boardService.list();
		model.addAttribute("list", list);
		return "board/list";
	}
}












