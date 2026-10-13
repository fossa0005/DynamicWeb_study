package com.ssafy.prj.login;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		switch (act) {
		case "loginForm":
			loginForm(request, response);
			break;
		case "login":
			login(request, response);
			break;
		case "logout":
			logout(request, response);
			break;
		}
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect(request.getContextPath() + "/main");
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Login login = new Login();
		login.setId(id);
		login.setPassword(password);
		
		LoginDao loginDao = LoginDao.getInstance();
		login = loginDao.selectLogin(login);
		
		// 성공 : main.jsp
		if (login == null) {
			// 실패 : loginForm.jsp
			response.sendRedirect(request.getContextPath() + "/login?act=loginForm");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			
//			request.setAttribute("login", login);	// redirect : 데이터 공유 안됨.
			response.sendRedirect(request.getContextPath() + "/main");
		}
		
	}

	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
		rd.forward(request, response);
	}
	
}









