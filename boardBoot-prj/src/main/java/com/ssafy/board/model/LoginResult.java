package com.ssafy.board.model;

public class LoginResult {
	private final String status;
	private final Member member;
	
	public LoginResult(String status, Member member) {
		super();
		this.status = status;
		this.member = member;
	}

	public String getStatus() {
		return status;
	}

	public Member getMember() {
		return member;
	}
	
	
}
