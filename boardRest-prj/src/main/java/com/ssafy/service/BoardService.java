package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.model.Board;


public interface BoardService {

	public List<Board> getBoardList(String keyword) throws SQLException;
	
	public Board getBoardDetail(int no) throws SQLException;
	
	//1행이 잘 수정되면 true 반환
	public boolean updateBoard(int no, Board board) throws SQLException;
	
	public boolean deleteBoard(int no) throws SQLException;
}
