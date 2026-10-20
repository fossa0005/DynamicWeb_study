package com.ssafy.prj.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.ssafy.prj.login.Login;


@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardService service = BoardServiceImpl.getInstance();
    
    public BoardServlet() {
        super();
    }
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String act = request.getParameter("act");
    	System.out.println(act);
    	if(act == null) {
    		act = "list";
    	}
    	
    	switch(act) {
    	case "list": list(request, response); break;
    	case "detail" : detail(request, response); break;
    	case "writeForm" : writeForm(request, response); break; //게시글작성 페이지
    	case "write" : write(request, response); break; //게시글 등록
    	case "delete" : delete(request, response); break;
    	case "updateForm" : updateForm(request, response); break;
    	
    	}
    	
	}
    
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<Board> boards = service.getBoardList();
    	request.setAttribute("boards", boards);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
    	
    	rd.forward(request, response);
    }
    
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Board board = service.getBoardDetail(Integer.parseInt(request.getParameter("no")));
    	
    	//서버가 찾은 객체 -> attribute 
    	request.setAttribute("board", board);
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/detail.jsp");
    	rd.forward(request, response);
    }
    
    public void writeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/write.jsp");
		rd.forward(request, response);
    }
    
    public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	Login login = (Login)session.getAttribute("login");
    	
    	//클라이언트가 전송한 값 -> parameter
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	String writer = login.getId();
    	
    	service.writeBoard(title, content, writer);
    	
    	request.setAttribute("boards", service.getBoardList());
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
    	rd.forward(request, response);
    }
    
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int no = Integer.parseInt(request.getParameter("no"));
    	service.deleteBoard(no);
    	
    	request.setAttribute("boards", service.getBoardList());
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
    	rd.forward(request, response);
    }
    
    public void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/update.jsp");
		Board board = service.findB
		rd.forward(request, response);
	}
    
    
    
    
    
}
