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

    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String act = request.getParameter("act");
    	
    	switch(act) {
    	case "loginForm" : loginForm(request, response); break;
    	case "logout" : logout(request, response); break;
    	}
    	
    }
 
    
    //로그인 검증
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	//jsp에서 전달받은 id pw입력값을 login객체로 만듦
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	Login login = new Login();
    	login.setId(id);
    	login.setPassword(password);
    	
    	//유효한 입력이면 login객체 반환, 아니면 null반환
    	LoginDao loginDao = LoginDao.getInstance();
    	login = loginDao.selectLogin(login);
    	
    	//실패
    	if(login == null) { 
    		response.sendRedirect(request.getContextPath() + "/login?act=loginForm");
    	
    	//성공
    	} else { 
    		HttpSession session = request.getSession();
    		session.setAttribute("login", login);
    		//request.setAttribute("login", login); //한 요청에서만 유지되므로 리다이렉트에서는 유지안됨 
    		response.sendRedirect(request.getContextPath() + "/main");
    	}
    	
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/main");
    	
    }
    
    //로그인, 회원가입
    private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login");
    	rd.forward(request, response);
    }
}
