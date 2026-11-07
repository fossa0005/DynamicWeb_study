package com.ssafy.board.service;

import java.sql.SQLException;

import com.ssafy.board.model.LoginResult;

public interface LoginService {
	LoginResult login(String id, String pw) throws SQLException ;
	
	

}
