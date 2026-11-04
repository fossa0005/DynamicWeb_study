package com.ssafy.board.model;

public class Board {
	private String title, content, writer, regDate;
	private int no, viewCnt;
	
	public Board() {
	}
	
	public Board(int no, String title, String content, String writer, String regDate, int viewCnt) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public int getViewCnt() {
		return no;
	}

	public void setViewCnt(int no) {
		this.no = no;
	}
	
}
