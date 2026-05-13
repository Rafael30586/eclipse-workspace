package com.rafael;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/demo-servlet")
public class DemoServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// String nombre = "Rafael";
		
		List<Estudiante> estudiantes = List.of(new Estudiante(1, "Rafael"), new Estudiante(2, "Mario"));
		
		// Estudiante e = new Estudiante(1, "Rafael");
		
		request.setAttribute("pibes", estudiantes);
		
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);
		
	}

}
