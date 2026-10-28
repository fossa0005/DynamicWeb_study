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
    	case "loginForm" : loginForm(request, response); break; //로그인화면
    	case "login" : login(request, response); break; //로그인 검사
    	case "logout" : logout(request, response); break; //로그아웃
    	}
    	
    }
    
    //로그인 화면
    private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
    	rd.forward(request, response);
    }
 
    
    //로그인 검사
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
    		request.setAttribute("login", "fail");
    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
    		rd.forward(request, response);
    	//성공
    	} else { 
    		//request.setAttribute("login", login); //한 요청에서만 유지되므로 리다이렉트에서는 유지안됨 
    		HttpSession session = request.getSession();
    		session.setAttribute("login", login); //세션에 로그인객체 저장
    		response.sendRedirect(request.getContextPath() + "/main");
    	}
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/main");
    	
    }
    
    
}
