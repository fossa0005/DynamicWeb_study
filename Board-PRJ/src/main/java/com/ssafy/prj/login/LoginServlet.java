package com.ssafy.prj.login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

    
    protected void service(HttpServletRequest request, HttpServletResponse response) {
    	
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	response.sendRedirect(request.getContextPath() + "/main");
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	Login login = new Login();
    	login.setId(id);
    	login.setPassword(password);
    	
    	LoginDao loginDao = LoginDao.getInstance();
    	login = loginDao.selectLogin(login);
    	
    	//성공
    	if(login == null) { 
    		response.sendRedirect(request.getContextPath() + "/login?act=loginForm");
    		
    	} else { 
    		HttpSession session = request.getSession();
    		session.setAttribute("login", login);
    		RequestDispatcher rd = request.getRequestDispatcher("/main");
    	}
    	
    }
    
    private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login");
    	rd.forward(request, response);
    }
}
