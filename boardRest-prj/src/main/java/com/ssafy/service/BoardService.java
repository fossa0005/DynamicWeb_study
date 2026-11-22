package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.model.Board;


public interface BoardService {

	
	public List<Board> getBoardList(String keyword) throws SQLException;
	
	public Board getBoardDetail(int no) throws SQLException;
	
	public void updateBoard(int no, Board board) throws SQLException;
	
	
}
