package com.ssafy.myprj.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myprj.model.dto.Board;

public interface BoardService {
	List<Board> list() throws SQLException ;
}
