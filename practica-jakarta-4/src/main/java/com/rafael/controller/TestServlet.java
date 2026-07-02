package com.rafael.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestServlet extends HttpServlet {
	
       
   
    public TestServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Esto es para pruebas");
		
		Connection connection = (Connection) request.getServletContext().getAttribute("dbConnection");	
        // System.out.println("Conexión: "+connection);
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM personajes");
			ResultSet rs = statement.executeQuery();
			while(rs != null && rs.next()) {
				out.println(rs.getString("nombre") + "--------" + rs.getString("apodo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection connection = (Connection) request.getServletContext().getAttribute("dbConnection");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apodo = request.getParameter("apodo");
		
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO personajes(id,nombre,apodo) VALUES(?,?,?)");
			statement.setInt(1, id);
			statement.setString(2, nombre);
			statement.setString(3, apodo);
			
			int filas = statement.executeUpdate();
			System.out.println("Filas insertadas: "+filas);
			
			if(nombre != null) {
				out.print("El personaje "+nombre+" ha sido añadido a la base de datos");
			}else {
				out.print("El personaje "+apodo+" ha sido añadido a la base de datos");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
