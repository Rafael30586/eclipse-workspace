package com.rafael;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet2() {
        super();
        System.out.println("Soy el servlet 2");
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getMethod().equals("GET")) doGet(request,response);
		else if(request.getMethod().equals("POST")) doPost(request,response);
		else if(request.getMethod().equals("PUT")) doPut(request, response);
		else if(request.getMethod().equals("DELETE")) doDelete(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null) {
			for(Cookie c : cookies) {
				System.out.println("Nombre: "+c.getName());
				System.out.println("Valor: "+c.getValue());
				System.out.println("Dominio: "+c.getDomain());
				System.out.println("Ruta: "+c.getPath());
				System.out.println("Atributos: "+c.getAttributes()); // Por alguna razón el atributo da null
				System.out.println("Habilidad: "+c.getAttribute("habilidad"));
			}
		}
		
		out.print("Método GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("Método POST");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("Método PUT");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("Método DELETE");
	}

}
