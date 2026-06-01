package com.rafael.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class AuthenticationFilter extends HttpFilter implements Filter {
       
    public AuthenticationFilter() {
        super();
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String action = req.getServletPath();
		
		if("/".equals(action) || "/login".equals(action) || "/Login.jsp".equals(action)) {
			chain.doFilter(request, response);
			// return;
		}else {
			Object isLoggedObj = req.getSession().getAttribute("isLoggedIn");
			
			if(isLoggedObj != null) {
				boolean isLoggedIn = (Boolean) isLoggedObj;
				
				if(isLoggedIn) {
					chain.doFilter(request, response);
					return;
				}
				
				
			}
			String path = req.getContextPath()+"/";
			res.sendRedirect(path);
		}
		// res.sendRedirect("/");
	    
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
