package com.ssafy.prj.board;

import java.util.List;

public interface BoardService {
	//컨트롤러(서블릿) -> 서비스 -> DAO -> DB
	
	List<Board> getBoardList();
	
	Board getBoardDetail(int no);
	
	Board getBoardForEdit(int no);
	
	void updateBord(int no, String title, String content);
	
	void writeBoard(String title, String content, String writer);
	
	void deleteBoard(int no);

}
