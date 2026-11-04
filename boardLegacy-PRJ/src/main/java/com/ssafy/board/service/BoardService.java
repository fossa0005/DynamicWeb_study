package com.ssafy.board.service;

import java.util.List;

import com.ssafy.board.model.Board;

public interface BoardService {
	
	List<Board> getBoardList();
	
	Board getBoardDetail(int no);
	
	void writeBoard();
	
}
