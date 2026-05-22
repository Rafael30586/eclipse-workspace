package com.rafael.filtros;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class Filtro2 extends HttpFilter implements Filter {
       
  
    public Filtro2() {
        super();
        
    }

	
	public void destroy() {
		System.out.println("Chau filtro 2");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String clave = request.getParameter("clave");
		PrintWriter writer = response.getWriter();
		
		if (clave.equals("789")) {
			chain.doFilter(request, response);
			System.out.println("Hola"); // Esto se ejecuta después de que la respuesta regresa del servlet al filtro
		}else {
			writer.print("Error");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Hola filtro 2");
		
	}

}
