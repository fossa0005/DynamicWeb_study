package com.ssafy.prj.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.util.List;

import com.ssafy.prj.login.Login;


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
    	case "writeForm" : writeForm(request, response); break; //게시글작성 페이지
    	case "write" : write(request, response); break; //게시글 등록
    	}
    	
	}
    
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BoardDao dao = new BoardDao();
    	List<Board> boards = dao.selectBoard();
 
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
    	
    	rd.forward(request, response);
    }
    
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Board board = dao.findByNo(Integer.parseInt(request.getParameter("no")));
    	board.setViewCnt(board.getViewCnt()+1);
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
    	BoardDao dao = new BoardDao();
    	HttpSession session = request.getSession();
    	Login login = (Login)session.getAttribute("login");
    	
    	
    	//클라이언트가 전송한 값 -> parameter
    	String title = request.getParameter("title");
    	String content = request.getParameter("content");
    	String writer = login.getId();
    	int viewCnt = 0;
    	
    	Board board = new Board(0,title,content, writer, viewCnt);
    	dao.postBoard(board);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
    	rd.forward(request, response);
    }
    
    
}
