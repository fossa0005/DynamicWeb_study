package com.ssafy.prj.board;

//싱글톤
public class BoardServiceImpl implements BoardService{
	private static BoardService instance;
	
	private BoardServiceImpl() {
		
	}
	
	public static synchronized BoardService getInstance() {
		if(instance == null) instance = new BoardServiceImpl();
		
		return instance;
	}
	
	
	
	
}
