package com.ssafy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.ssafy.board.model.Board;
import com.ssafy.board.util.DBUtil;

@Repository
public class BoardDao {
	private final DBUtil dbutil;
	
	private BoardDao(DBUtil dbutil) {
		this.dbutil = dbutil;
	}
	
	public List<Board> selectAll() throws Exception {
		List<Board> boards = new ArrayList<>();
		
		try {
			Connection conn = dbutil.getConnection();
			String sql = """
					select no, 
						title, 
						content, 
						writer,
						to_char(regDate, YY/MM/DD hh:mm) as regDate,
						viewCnt 
					from board
					""";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
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
			
		} catch (Exception e) {
			throw e;
		} finally {
			dbutil.close(rs);
			dbutil.close(pstmt);
		}

		
		
		
		return boards;
	}
	

}
