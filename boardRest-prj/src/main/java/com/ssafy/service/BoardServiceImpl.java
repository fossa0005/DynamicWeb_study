package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.dao.BoardDao;
import com.ssafy.model.Board;

@Service
public class BoardServiceImpl implements BoardService {
	private final BoardDao dao;
	
	BoardServiceImpl(BoardDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<Board> getBoardList(String keyword) throws SQLException {
		return dao.select(keyword);
	}

	@Override
	public Board getBoardDetail(int no) throws SQLException {
		dao.increaseViewCnt(no);
		return dao.findByNo(no);
	}

	@Override
	public boolean updateBoard(int no, Board board) throws SQLException {
		return dao.update(board);
	}

	@Override
	public boolean deleteBoard(int no) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
