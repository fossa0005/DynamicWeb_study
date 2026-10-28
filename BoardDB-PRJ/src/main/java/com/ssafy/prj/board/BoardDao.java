package com.ssafy.prj.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.protocol.Resultset;
import com.ssafy.prj.util.DBUtil;

//싱글톤
public class BoardDao {
	private DBUtil dbUtil;
	private static BoardDao instance;

	
	private BoardDao() {
		dbUtil = new DBUtil();
	};
	
	public static synchronized BoardDao getInstance() {
		if(instance == null) instance = new BoardDao();
		return instance;
	}

	public List<Board> selectBoard() {
		return;
	}
	
	public Board findByNo(int no) throws SQLException {	
		//얘 서비스계층에서 생성하는게 맞지않냐?
		Connection conn = dbUtil.getConnection();
		String sql = """
			select *
			from board
			where no = ?
		""";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int viewCnt = rs.getInt("viewCnt");
			Board board = new Board();
			board.setNo(no);
			board.setTitle(title);
			board.setViewCnt(viewCnt);
			board.setWriter(writer);
			
			return board;
		}
		
		
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
