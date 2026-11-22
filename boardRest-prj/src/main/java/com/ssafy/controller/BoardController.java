package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.Board;
import com.ssafy.service.BoardService;

import jakarta.websocket.server.PathParam;


@RestController //모든 메서드가 @ResponseBody 어노테이션 붙인 효과
public class BoardController {
	private final BoardService service;
	
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping("/boards")
	@ResponseBody //화면x, 데이터만 jackson이 자바객체를 json형식으로 반환함(REST 방식)
	public List<Board> list(@RequestParam(defaultValue = "") String keyword) throws SQLException { 
		return service.getBoardList(keyword);
	}
	
	@GetMapping("/boards/{no}")
	public Board detail(@PathVariable int no) throws SQLException {
		return service.getBoardDetail(no);
	}
	
	//restApi는 자원중심 url로, url 같아도 메서드 다를 수 있음
	//requsetBody : 요청으로 들어온 json을 자바객체로 받음
	@PutMapping("/boards/{no}")
	public Board update(@PathVariable int no, @RequestBody Board board) throws SQLException {
		
		service.updateBoard(no, board);
		
		return service.getBoardDetail(no);
	}
}
