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

}
