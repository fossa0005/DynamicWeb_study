package com.ssafy.prj.board;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	private static List<Board> boards = new ArrayList<>();
	private static int no = 0;
	static {
		boards.add(new Board(++no, "1빠", "제곧내1", "maria", 0));
		boards.add(new Board(++no, "2빠", "제곧내2", "maria", 0));
		boards.add(new Board(++no, "3빠","제곧내3", "maria", 0));
	}
	
	
	public static int getNo() {
		return no;
	}
	
	public static void setNo(int no) {
		BoardDao.no = no;
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
	
	public void postBoard(Board board) {
		board.setNo(++no);
		boards.add(board);
	}
	
	public void deleteBoard(int no) {
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getNo() == no) {
				boards.remove(i);
				return;
			}
		}
	}

}
