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

public class Filtro1 extends HttpFilter implements Filter {
       
    public Filtro1() {
        super();
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String clave = "123456";
		PrintWriter writer = response.getWriter();
		
		if(request.getParameter("clave").equals(clave)) chain.doFilter(request, response); 
		else writer.print("error");
		    
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
