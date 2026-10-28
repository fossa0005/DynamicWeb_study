package com.ssafy.prj.login;

import java.util.HashMap;
import java.util.Map;

//싱글톤
public class LoginDao {
	private static Map<String, String> members = new HashMap<>(); //아이디 : 비밀번호
	private static LoginDao instance;
	
	static {
		members.put("maria", "1111");
		members.put("admin", "1111");
		members.put("fossa", "1111");
	}
	
	private LoginDao() {}
	
	public static synchronized LoginDao getInstance() {
		if(instance == null) {
			instance = new LoginDao();
		}
		
		return instance;
	}
	
	//전달받은 로그인 객체의 id가 DB에 존재하지 않거나
	//id의 비밀번호가 다르면 null 반환
	public Login selectLogin(Login param) {
		String id = param.getId();
		String password = param.getPassword();
		if(members.get(id) == null) return null;
		if(members.get(id).equals(password) == false) return null;
		
		Login login = new Login();
		login.setId(id);
		login.setPassword(password);
		
		return login;
	}

}
