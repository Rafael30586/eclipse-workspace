package com.rafael;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet1 extends HttpServlet {
	
	
    public Servlet1() {
        super();
        System.out.println("Soy el Servlet1");
    }

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		
		return null; 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<span> Servlet1: Método Get </span>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
		
        out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<span> Servlet1: Método Post </span>");
		out.println("</body>");
		out.println("</html>");
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
		
        out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<span> Servlet1: Método Put </span>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
		
        out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<span> Servlet1: Método Delete </span>");
		out.println("</body>");
		out.println("</html>");
	}

}
