package com.rafael;


import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.rafael.dao.PersonajeDao;
import com.rafael.model.Personaje;


public class obtenerPersonajeController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid")); 
		PersonajeDao dao = new PersonajeDao();
		Personaje p1 = dao.obtenerPersonaje(pid);
		
		HttpSession session = request.getSession();
		session.setAttribute("personaje",p1);
		
		//request.setAttribute("personaje", p1);
		/*
		RequestDispatcher rd = request.getRequestDispatcher("mostrarPersonaje.jsp");
		rd.forward(request, response);*/
		response.sendRedirect("mostrarPersonaje.jsp");
	}

	

}
