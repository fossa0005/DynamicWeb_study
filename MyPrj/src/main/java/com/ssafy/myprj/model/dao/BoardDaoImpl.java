package com.ssafy.myprj.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.myprj.model.dto.Board;
import com.ssafy.myprj.util.DBUtil;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private final DBUtil dbUtil;
	
//	@Autowired
	public BoardDaoImpl(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public List<Board> selectBoard() throws SQLException {
		try (
			Connection con = dbUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement("""
				select no, title, writer, reg_date as regDate
				  from board
				 order by no desc	
			""");
			ResultSet rs = pstmt.executeQuery();		
		) {
			List<Board> list = new ArrayList<>();
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("regDate");
				
				Board board = new Board();
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);
				
				list.add(board);
			}
			return list;
		}
	}
}










