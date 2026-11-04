package com.ssafy.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.dao.BoardDao;
import com.ssafy.board.model.Board;

@Service //알아서 싱글톤
public class BoardServiceImpl implements BoardService {
	private static BoardService instance;
	private final BoardDao dao; //DI
	
	//DI
	private BoardServiceImpl(BoardDao dao){
		this.dao = dao;
	}
	
	@Override
	public List<Board> getBoardList() {
		List<Board> boards = new ArrayList<>();
		return boards;
	}

	@Override
	public Board getBoardDetail(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeBoard() {
		// TODO Auto-generated method stub
		
	}

}
