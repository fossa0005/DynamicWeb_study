package com.ssafy.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.dao.BoardDao;
import com.ssafy.board.model.Board;

@Service //알아서 싱글톤
public class BoardServiceImpl implements BoardService {
	private final BoardDao dao; //DI
	
	//DI
	//public 쓰는게 표준
	public BoardServiceImpl(BoardDao dao){
		this.dao = dao;
	}
	
	@Override
	public List<Board> getBoardList() throws SQLException {
		return dao.selectAll();
	}

	@Override
	public Board getBoardDetail(int no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeBoard() {
		// TODO Auto-generated method stub
		
	}

}
