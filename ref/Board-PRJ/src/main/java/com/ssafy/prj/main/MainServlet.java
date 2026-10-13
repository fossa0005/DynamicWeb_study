package com.ssafy.prj.main;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// main.jsp 호출
		// forward : url  변경안됨.. , 데이터 공유
		// redirect : url 변경, 데이터 공유 안됨..
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main.jsp");
		rd.forward(request, response);
	}
}








