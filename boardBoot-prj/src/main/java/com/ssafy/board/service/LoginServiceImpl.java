package com.ssafy.board.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.board.dao.MemberDao;
import com.ssafy.board.model.LoginResult;
import com.ssafy.board.model.Member;

@Service
public class LoginServiceImpl implements LoginService  {
	private final MemberDao dao;
	
	public LoginServiceImpl(MemberDao dao) {
		this.dao = dao;
	}
	
	//로그인 결과객체(성공, id없음, 비밀번호 틀림) 반환 
	@Override
	public LoginResult login(String id, String pw) throws SQLException {
		Member member = dao.findById(id);
		if(member == null) return new LoginResult("id_not_found", member);
		if(! member.getPw().equals(pw)) return new LoginResult("wrong_password", member);
		else return new LoginResult("login_success", member);
	}

}
