package com.rafael;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/suma")
public class SumarServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;	
		
		Cookie cookie = new Cookie("k",k + "");
		res.addCookie(cookie);
		
		/*HttpSession sesion = req.getSession(true);
		sesion.setAttribute("k", k);*/
		
		
		
		res.sendRedirect("cuadrado?k="+k); // gracias a este método podemos llamar al otro servlet desde este. Reescritura de URL
		
		//req.setAttribute("k", k); // le está asignando un valor a la solicitud para que dicho valor pueda ser usado en otro servlet		
		/*
		RequestDispatcher rd = req.getRequestDispatcher("cuadrado");
		rd.forward(req, res); // le está pasando la solicitud y la respuesta al otro servlet
		*/
		
				
	}

}
