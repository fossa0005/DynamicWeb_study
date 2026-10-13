/*
 * C : create -> insertBoard
 * R : read   -> selectBoard
 *            -> selectBoardByPK
 * U : update -> updateBoard
 * D : delete -> deleteBoard
 */
package com.ssafy.prj.board;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	private static int boardNo = 0;
	private static List<Board> boards = new ArrayList<>();
	static {
		boards.add(new Board(++boardNo, "첫번째 게시글", "싸피", 0));
		boards.add(new Board(++boardNo, "두번째 게시글", "싸피2", 0));
		boards.add(new Board(++boardNo, "세번째 게시글", "싸피", 0));
	}
	public Board selectBoardByPK(int no) {
		for (Board board : boards) {
			if (board.getNo() == no) {
				return board;
			}
		}
		return null;
	}
	
	public List<Board> selectBoard() {
		return boards;
	}
}








