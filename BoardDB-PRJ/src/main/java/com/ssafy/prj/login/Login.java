package com.ssafy.prj.login;

public class Login {
	private String id, password, name;
	
	
	public Login() {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "login [id=" + id + ", password=" + password + ", name=" + name + "]";
	}

}
