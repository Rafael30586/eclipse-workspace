package com.rafael;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet Filter implementation class idFilter
 */
public class idFilter extends HttpFilter implements Filter {
       
    
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("En el filtro");
		HttpServletRequest req = (HttpServletRequest) request;
		int aid = Integer.parseInt(req.getParameter("aid"));
		
		PrintWriter out = response.getWriter();
		
		if(aid > 1) {
			chain.doFilter(request, response);
		}else {
			out.print("Entrada invalida");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
