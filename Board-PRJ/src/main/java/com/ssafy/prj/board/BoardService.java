package com.ssafy.prj.board;

import java.util.List;

public interface BoardService {
	//컨트롤러(서블릿) -> 서비스 -> DAO -> DB
	
	List<Board> getBoardList();
	
	Board getBoardDetail(int no);
	
	void updateBord(String title, String content, String writer);
	
	void writeBoard(String title, String content, String writer);
	
	void deleteBoard(int no);

}
