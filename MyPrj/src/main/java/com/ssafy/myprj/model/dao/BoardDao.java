package com.ssafy.myprj.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myprj.model.dto.Board;

public interface BoardDao {

	List<Board> selectBoard() throws SQLException ;
	
}
