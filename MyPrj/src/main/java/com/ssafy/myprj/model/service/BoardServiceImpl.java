package com.ssafy.myprj.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.myprj.model.dao.BoardDao;
import com.ssafy.myprj.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDao boardDao;
//	@Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}


	public List<Board> list() throws SQLException {
		List<Board> list = boardDao.selectBoard();
		return list;
	}
}












