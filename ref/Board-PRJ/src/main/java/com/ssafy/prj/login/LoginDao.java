package com.ssafy.prj.login;

import java.util.HashMap;
import java.util.Map;

public class LoginDao {
	
	private static LoginDao instance;
	private LoginDao() {}
	public static synchronized LoginDao getInstance() {
		if (instance == null) {
			instance = new LoginDao();
		}
		return instance;
	}
	
	private static Map<String, String> members = new HashMap<>();
	static {
		members.put("ssafy", "1234");
		members.put("admin", "1234");
	}
	public Login selectLogin(Login param) {
		String id = param.getId();
		String password = param.getPassword();
		if (members.get(id) == null) return null;
		if (members.get(id).equals(password) == false) return null;
		
		Login login = new Login();
		login.setId(id);
		login.setPassword(password);
		login.setName("싸피");
		return login;
	}
}







