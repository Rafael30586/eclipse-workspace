package com.rafael;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cuadrado")
public class CuadradoServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		int k = 0;
		/*HttpSession sesion = req.getSession();
		
		int k = (int)sesion.getAttribute("k");*/
		
		Cookie[] cookies = req.getCookies();
		
		for(Cookie c : cookies) {
			if(c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
			}
		}
		
		// sesion.removeAttribute("k"); de esta manera podemos quitar el atributo de la sesión
		
		//int k = (int)req.getAttribute("k"); // A esta k la trae de la solicitud del otro servlet (SumarServlet)
		//int k = Integer.parseInt(req.getParameter("k")); // A este parámetro lo trae del método sendRedirect
		k = k * k;
		PrintWriter out = res.getWriter();
		out.print("<html><body bgcolor='#0170ed'>");
		out.println("El resultado es: " + k );
		out.print("</body></html>");
		
		
		System.out.println("Cuadrado llamado");
	}

}
