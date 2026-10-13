package com.ssafy.prj.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardDao dao = new BoardDao();  
    
    public BoardServlet() {
        super();
    }
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String act = request.getParameter("act");
    	
    	if(act == null) {
    		act = "list";
    	}
    	
    	switch(act) {
    	case "list": list(request, response); break;
    	case "detail" : detail(request, response); break;
    	case "writeForm" : writeForm(request, response); break;
    	}
    	
	}
    
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BoardDao dao = new BoardDao();
    	List<Board> boards = dao.selectBoard();
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board?act=list");
    	
    	rd.forward(request, response);
    }
    
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Board board = dao.findByNo(Integer.parseInt(request.getParameter("no")));
    	board.setViewCnt(board.getViewCnt()+1);
    	request.setAttribute("board", board);
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/detail.jsp");
    	rd.forward(request, response);
    }
    
    public void writeForm(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/write.jsp");
	}
}
