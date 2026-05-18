package com.rafael;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;


public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Servlet4() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String basicAuth = request.BASIC_AUTH;
		HttpServletMapping mapeoDeServlet = request.getHttpServletMapping();
		Enumeration<String> nombresHeaders = request.getHeaderNames();
		
		System.out.println(basicAuth);
		System.out.println(mapeoDeServlet.getServletName());
		System.out.println(mapeoDeServlet.getPattern());
		
		while(nombresHeaders.hasMoreElements()) {
			System.out.println(nombresHeaders.nextElement());
		}
		
		System.out.println("Cabecera de autorización: "+request.getHeader("authorization"));
		System.out.println("Cabecera de anfitrión: "+request.getHeader("host"));
		System.out.println("Cabecera de conexión: "+request.getHeader("connection"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
