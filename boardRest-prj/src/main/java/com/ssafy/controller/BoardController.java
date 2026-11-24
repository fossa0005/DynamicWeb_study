package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.Board;
import com.ssafy.service.BoardService;



@RestController //모든 메서드가 @ResponseBody 어노테이션 붙인 효과
@RequestMapping("/boards")
public class BoardController {
	private final BoardService service;
	
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	@ResponseBody //화면x, jackson이 자바객체를 json형식으로 데이터만 반환하는 어노테이션(REST 방식)
	public ResponseEntity<List<Board>> list(@RequestParam(defaultValue = "") String keyword) throws SQLException { 
		List<Board> boards = service.getBoardList(keyword);
		return ResponseEntity.status(HttpStatus.OK).body(boards); //비축약형
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<Board> detail(@PathVariable int no) throws SQLException {
		Board board = service.getBoardDetail(no);
		if (board == null) {
			return ResponseEntity.notFound().build(); //축약형
		}
		return ResponseEntity.ok().body(board);
	}
	
	//restApi는 자원중심 url로, url 같아도 메서드 다를 수 있음
	//requsetBody : 요청으로 들어온 json을 자바객체로 받음
	@PutMapping("/{no}")
	public ResponseEntity<Board> update(@PathVariable int no, @RequestBody Board board) throws SQLException {
		if (! service.updateBoard(no, board)) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.noContent().build(); //204no_content: 응답 본문이 없는 성공
	}
	
	@DeleteMapping("/{no}")
	public ResponseEntity<String> delete(@PathVariable int no) throws SQLException {
		if(! service.deleteBoard(no)) {
			return ResponseEntity.internalServerError().build();
		}
		
		return ResponseEntity.ok().build();
		
	}

