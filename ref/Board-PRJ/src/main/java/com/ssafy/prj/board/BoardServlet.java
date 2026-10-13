package com.ssafy.prj.board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println("action : " + act);
		if (act == null) act = "list";
		
		if (act.equals("list")) {
			System.out.println("목록");
			list(request, response);
		} else if (act.equals("detail")) {
			detail(request, response);
		} else if (act.equals("writeForm")) { 
			
		} else if (act.equals("write")) {
			
		} else if (act.equals("modifyForm")) {
			
		} else if (act.equals("modify")) {
			
		} else if (act.equals("delete")) {
			
		}
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao dao = new BoardDao();
		Board board = dao.selectBoardByPK(no);
		request.setAttribute("board", board);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/detail.jsp");
		rd.forward(request, response);		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		BoardDao dao = new BoardDao();
		List<Board> boards = dao.selectBoard();
		request.setAttribute("boards", boards);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/list.jsp");
		rd.forward(request, response);
	}
}





