package com.ssafy.board.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.Board;

public interface BoardService {
	
	List<Board> getBoardList() throws SQLException;
	
	Board getBoardDetail(int no) throws SQLException;
	
	void writeBoard();
	
}
