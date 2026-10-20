package com.ssafy.prj.board;

import java.util.List;

//싱글톤
public class BoardServiceImpl implements BoardService{
	private static BoardService instance;
	BoardDao dao = BoardDao.getInstance();
	
	private BoardServiceImpl() {
	}
	
	public static synchronized BoardService getInstance() {
		if(instance == null) instance = new BoardServiceImpl();
		
		return instance;
	}
	
	//리스트
	@Override
	public List<Board> getBoardList() {
		List<Board> boards = dao.selectBoard();
		return boards;
	}
	
	//디테일
	@Override
	public Board getBoardDetail(int no) {
		Board board = dao.findByNo(no);
		dao.increaseViewCnt(no);
		return board;
	}
	
	//수정
	@Override
	public void updateBord(String title, String content, String writer) {
		Board board = new Board(0, title, content, writer, 0);
		
		
	}
	
	//등록
	@Override
	public void writeBoard(String title, String content, String writer) {
		Board board = new Board(0, title, content, writer, 0);
		dao.insert(board);
	}
	
	//삭제
	@Override
	public void deleteBoard(int no) {
		dao.deleteByNo(no);
	}

	
	
	
	
	
	
	
}
