package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.model.Board;
import com.ssafy.util.DBUtil;

@Component
public class BoardDao {
	private final DBUtil dbutil;
	
	public BoardDao(DBUtil dbutil) {
		this.dbutil = dbutil;
	}
	
	public List<Board> select(String keyword) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> boards = new ArrayList<>();
		
		try {
			String sql = """
					select b.no,
						b.title,
						b.content,
						m.id as writer,
						date_format(b.reg_date, "%Y-%m-%d %H:%i:%s") as reg_date,
						b.view_cnt
					from board b 
					left outer join member m on b.member_id = m.member_id
					where b.title like ? 
					""";
			conn = dbutil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%"); //형식자표시 따옴표 없어도 됨 
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String writer = rs.getString("writer");
			String regDate = rs.getString("reg_date");
			int viewCnt = rs.getInt("view_cnt");
			
			boards.add(new Board(no, viewCnt, title, content, writer, regDate));
		}
		} finally {
			dbutil.close(rs, pstmt, conn);
		}
		
		
		
		return boards;
		
	}

	public Board findByNo(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;
		
		try {
			String sql = """
					select b.no,
						b.title,
						b.content,
						m.id as writer,
						date_format(b.reg_date, "%Y-%m-%d %H:%i:%s") as reg_date,
						b.view_cnt
					from board b 
					left outer join member m on b.member_id = m.member_id
					where b.no = ?
					""";
			conn = dbutil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				int viewCnt = rs.getInt("view_cnt");
				board = new Board(no, viewCnt, title, content, writer, regDate);
			}
			
			return board;
			
			
		} finally {
			dbutil.close(rs, pstmt, conn);
		}
	}
	
	public void increaseViewCnt(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = """
					update board(view_cnt)
					values(?)
					where no = ?
					""";
			conn = dbutil.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, );
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
			
		} finally {
			dbutil.close(pstmt, conn);
		}
	}
	
	public void update(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			String sql = """
					update board
					set view_cnt = view_cnt + 1
					where no = ?
					""";
			conn = dbutil.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		} finally {
			dbutil.close(conn, pstmt);
		}
	}
	
}
