package com.ssafy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.board.model.Member;
import com.ssafy.board.util.DBUtil;

@Repository
public class MemberDao {
	private final DBUtil dbutil;
	
	public MemberDao(DBUtil dbutil) {
		this.dbutil = dbutil;
	}

	public Member findById(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			conn = dbutil.getConnection();
			String sql = """
					select *
					from member
					where id = ?
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int memberId = rs.getInt("member_id");
				String pw = rs.getString("pw");
				member = new Member(memberId, id, pw);		
			}
			
		} finally {
			dbutil.close(rs, pstmt, conn);
		}
		
		return member;
	}

}
