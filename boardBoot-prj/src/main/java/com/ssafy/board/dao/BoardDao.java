package com.ssafy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.board.model.Board;
import com.ssafy.board.util.DBUtil;

@Component
public class BoardDao {
	private final DBUtil dbutil;
	
	public BoardDao(DBUtil dbutil) {
		this.dbutil = dbutil;
	}
	
	public List<Board> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<>();
		
		try {
			String sql = """
					select
						b.no,
						b.title,
						b.content,
						m.id as writer,
						b.Date_format(regDate, '') as regDate,
						member
					from board b, member m
					left outer join on b.member_id = m.member_id
					""";
			
			conn = dbutil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				
				list.add(new Board())
			}
		} finally {
			
		}
		
		return list;
	}
	
}
