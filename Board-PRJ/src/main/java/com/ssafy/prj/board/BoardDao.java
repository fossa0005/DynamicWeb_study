package com.ssafy.prj.board;

import java.util.ArrayList;
import java.util.List;

//싱글톤
public class BoardDao {
	private static BoardDao instance;
	private static List<Board> boards = new ArrayList<>();
	private static int no = 0; //PK
	
	static {
		boards.add(new Board(++no, "1빠", "제곧내1", "maria", 0));
		boards.add(new Board(++no, "2빠", "제곧내2", "maria", 0));
		boards.add(new Board(++no, "3빠","제곧내3", "maria", 0));
	}
	
	private BoardDao() {};
	
	public static synchronized BoardDao getInstance() {
		if(instance == null) instance = new BoardDao();
		return instance;
	}

	public List<Board> selectBoard() {
		return boards;
	}
	
	public Board findByNo(int no) {
		for(Board board : boards) {
			if(no == board.getNo()) {
				return board;
			}
		}
		return null;
	}
	
	public void insert(Board board) {
		board.setNo(++no);
		boards.add(board);
	}
	
	public void deleteByNo(int no) {
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getNo() == no) {
				boards.remove(i);
				return;
			}
		}
	}
	
	public void updateByNo(int no, String title, String Content) {
			int index = -1;
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getNo() == no) {
				index = i;
				break;
			}
		}
		
		boards.get(index).setTitle(title);
		boards.get(index).setContent(Content);
	}
	
	public void increaseViewCnt(int no) {
		Board board = findByNo(no);
		board.setViewCnt(board.getViewCnt() + 1);
	}
	
	

}
