package com.ssafy.board.service;

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
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
