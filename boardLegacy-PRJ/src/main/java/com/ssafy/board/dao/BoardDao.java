package com.ssafy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.ssafy.board.model.Board;
import com.ssafy.board.util.DBUtil;

@Repository
public class BoardDao {
	private final DBUtil dbutil;
	
	//DI
	public BoardDao(DBUtil dbutil) {
		this.dbutil = dbutil;
	}
	
	public List<Board> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> boards = new ArrayList<>();
		
		try {
			conn = dbutil.getConnection();
			// 연도 두자리, 24시간제
			String sql = """
					select no, 
						title, 
						content, 
						writer,
						date_format(regDate, '%y/%m/%d %H:%m') as regDate,
						viewCnt 
					from board
					""";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int no = rs.getInt("no");
				String title  = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String regDate = rs.getString("regDate");
				int viewCnt = rs.getInt("viewCnt");
				
				Board board = new Board(no, title, content, writer, regDate, viewCnt);
				boards.add(board);
			}
			
		} finally {
			dbutil.close(rs, pstmt, conn);
		}
		
		Collections.sort(boards, (o1, o2) -> o2.getNo() - o1.getNo());
		return boards;
	}
	
	public Board findByNo(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		Board board = null;
		
		try {
			conn = dbutil.getConnection();
			String sql = """
					select no, 
						title, 
						content, 
						writer,
						date_format(regDate, '%y/%m/%d %H:%m') as regDate,
						viewCnt
					from board
					where no = ?
						""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs  = pstmt.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String regDate = rs.getString("regDate");
				int viewCnt = rs.getInt("viewCnt");
				
				board = new Board(no, title, content, writer, regDate, viewCnt);
			}	
		} finally {
			dbutil.close(rs, pstmt, conn);
		}
		
		return board;	
	}
	
	public void increaseViewCnt(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbutil.getConnection();
			String sql = """
					update board
					set viewCnt = viewCnt+1
					where no = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} finally {
			dbutil.close(rs, pstmt, conn);
		}
	}
	
	
	

}
