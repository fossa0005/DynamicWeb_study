package com.ssafy.board.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.dao.BoardDao;
import com.ssafy.board.model.Board;

@Service
public class BoardServiceImpl implements BoardService {
	private final BoardDao dao;
	
	public BoardServiceImpl(BoardDao dao) {	
		this.dao = dao;
	}
	
	@Override
	public List<Board> getBoardList() throws SQLException {
		return dao.selectAll();
	}

	@Override
	public Board getBoardDetail(int no) throws SQLException {
		
		return null;
	}

}
