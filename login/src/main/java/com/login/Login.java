package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.login.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		LoginDao dao = new LoginDao();
		
		if(dao.check(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("welcome.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	
	}

}
