package com.rafael;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class Filtro extends HttpFilter implements Filter {
       
  
    public Filtro() {
        super();
       
    }


	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    String clave = request.getParameter("clave");
	    PrintWriter writer = response.getWriter();
		
	    if(clave.equals("123456")) chain.doFilter(request, response);
	    else writer.print("Error");

			}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Soy un filtro");

	}

}
