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
						Date_format(b.reg_date, "%Y-%m-%d %H:%i:%s") as reg_date,
						view_cnt
					from board as b
					left outer join member as m 
					on b.member_id = m.member_id
					""";
			
			conn = dbutil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				int viewCnt = rs.getInt("view_cnt");
				
				list.add(new Board(title, content, writer, regDate, no, viewCnt));
			}
		} finally {
			dbutil.close(rs, pstmt, conn);
		}
		
		return list;
	}
	
}
