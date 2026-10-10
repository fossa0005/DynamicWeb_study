package com.ssafy.prj.board;

public class Board {
	private int no, viewCnt;
	private String title, content, writer;
	
	Board(int no, String title, String content, String writer, int viewCnt) {
		this.no = no;
		this.title = title;
		this.viewCnt = viewCnt;
		this.content = content;
		this.writer = writer;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
}
