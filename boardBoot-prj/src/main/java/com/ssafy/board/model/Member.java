package com.ssafy.board.model;

public class Member {
	private String id, pw;
	private int memberId;
	
	public Member() {
	}
	
	public Member(int memberId, String id, String password) {
		super();
		this.id = id;
		this.pw = password;
		this.memberId = memberId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public int getMemberId() {
		return memberId;
	}
	
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	
}
