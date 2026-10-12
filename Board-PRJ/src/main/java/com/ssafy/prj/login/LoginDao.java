package com.ssafy.prj.login;

import java.util.HashMap;
import java.util.Map;

//싱글톤
public class LoginDao {
	//아이디 : 비밀번호
	private static Map<String, String> members = new HashMap<>();
	private static LoginDao instance;
	
	static {
		members.put("maria", "1234");
		members.put("admin", "1234");
	}
	
	private LoginDao() {}
	
	public static synchronized LoginDao getInstance() {
		if(instance == null) {
			instance = new LoginDao();
		}
		
		return instance;
	}
	
	public Login selectLogin(Login param) {
		String id = param.getId();
		String password = param.getPassword();
		if(members.get(id) == null) return null;
		if(members.get(id).equals(password) == false) return null;
		
		Login login = new Login();
		login.setId(id);
		login.set
	}

}
